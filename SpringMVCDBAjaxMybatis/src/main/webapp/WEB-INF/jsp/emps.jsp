<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
    하나의 jsp 에서 CRUD 를 한 꺼번에 처리
    비동기요청 (ajax) 는 fetch 함수가 나오기 전까지 매우 복잡한 구조를 가져서 불편
    
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>사원 관리</h1>
    <table>
        <thead>
            <tr><th>employeeId</th><th>firstName</th><th>lastName</th><th>email</th><th>hireDate</th></tr>
        </thead>
        <tbody id="empTbody">
        </tbody>
    </table>
    <hr>
    <form>
        <input type="text" name="employeeId" id="employeeId"></input><br>
        <input type="text" name="firstName" id="firstName"></input><br>
        <input type="text" name="lastName" id="lastName"></input><br>
        <input type="text" name="email" id="email"></input><br>
        <input type="text" name="hireDate" id="hireDate"></input><br>
    </form>   
    <hr>
    <button type="button" id="btnInsert">등록</button> <button type="button" id="btnUpdate">수정</button> <button type="button" id="btnDelete">삭제</button>
    
    <script>
        window.onload = function(){
            listEmp();
            
            document.querySelector("#btnInsert").onclick = insertEmp;
            document.querySelector("#btnUpdate").onclick = updateEmp;
            document.querySelector("#btnDelete").onclick = deleteEmp;
        }
        
        
        async function listEmp(){
            let url = '/emps/list'
            let response = await fetch(url); // await : fetch() 종료될 때까지 기다려라.
            let data = await response.json();  // response 에 담긴 json 문자열을 javascritp ojbect 변환
            
            makeListHtml(data);
        }
        
        function makeListHtml(list){
            let listHTML = ``;
            
            list.forEach( el => {
                listHTML +=
                    `<tr data-employeeId="\${el.employeeId}">
                        <td>\${el.employeeId}</td>
                        <td>\${el.firstName}</td>
                        <td>\${el.lastName}</td>
                        <td>\${el.email}</td>
                        <td>\${el.hireDate}</td>
                    </tr>`;
            });
            
            document.querySelector("#empTbody").innerHTML = listHTML;
            
            document.querySelectorAll("#empTbody tr").forEach( el => {
                el.onclick = function(){
                    let employeeId = this.getAttribute("data-employeeId");
                    detailEmp(employeeId);
                }
            });
        }
        
        async function detailEmp(employeeId){
            console.log(employeeId);
            
            let url = '/emps/detail/' + employeeId;
            let response = await fetch(url); // await : fetch() 종료될 때까지 기다려라.
            let data = await response.json();  // response 에 담긴 json 문자열을 javascritp ojbect 변환
            
            document.querySelector("#employeeId").value = data.employeeId;
            document.querySelector("#firstName").value = data.firstName;
            document.querySelector("#lastName").value = data.lastName;
            document.querySelector("#email").value = data.email;
            document.querySelector("#hireDate").value = data.hireDate;
            
        }
        // post
        async function insertEmp(){
            
            let urlParams = new URLSearchParams({
                employeeId: document.querySelector("#employeeId").value,
                firstName: document.querySelector("#firstName").value,
                lastName: document.querySelector("#lastName").value,
                email: document.querySelector("#email").value,
                hireDate: document.querySelector("#hireDate").value
            });
            
            let fetchOptions = {
                method: "POST",
                body: urlParams
            }
            let url = '/emps/insert';
            let response = await fetch(url, fetchOptions); // await : fetch() 종료될 때까지 기다려라.
            let data = await response.json();  // response 에 담긴 json 문자열을 javascritp ojbect 변환
            
            alert("사원 등록");
            
            listEmp();
        }
        
        async function updateEmp(){
            
            let urlParams = new URLSearchParams({
                employeeId: document.querySelector("#employeeId").value,
                firstName: document.querySelector("#firstName").value,
                lastName: document.querySelector("#lastName").value,
                email: document.querySelector("#email").value,
                hireDate: document.querySelector("#hireDate").value
            });
            
            let fetchOptions = {
                method: "POST",
                body: urlParams
            }
            let url = '/emps/update';
            let response = await fetch(url, fetchOptions); // await : fetch() 종료될 때까지 기다려라.
            let data = await response.json();  // response 에 담긴 json 문자열을 javascritp ojbect 변환
            
            alert("사원 수정");
            
            listEmp();
        }
        
        async function deleteEmp(){
            let employeeId = document.querySelector("#employeeId").value;
            let url = '/emps/delete/' + employeeId;
            let response = await fetch(url); // await : fetch() 종료될 때까지 기다려라.
            let data = await response.json();  // response 에 담긴 json 문자열을 javascritp ojbect 변환
            
            alert("사원 삭제");
            
            listEmp();
        }
    </script>
</body>
</html>
