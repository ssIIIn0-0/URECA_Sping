<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>도서 관리</h1>
	<table>
		<thead>
			<tr>
				<th>bookId</th>
				<th>bookName</th>
				<th>publisher</th>
				<th>price</th>
			</tr>
		</thead>
		<tbody id="bookTbody">
		</tbody>
	</table>
	<hr>
	<form>
		<input type="text" name="bookId" id="bookId"></input><br> <input
			type="text" name="bookName" id="bookName"></input><br> <input
			type="text" name="publisher" id="publisher"></input><br> <input
			type="text" name="price" id="price"></input><br>
	</form>
	<hr>
	<button type="button" id="btnInsert">등록</button>
	<button type="button" id="btnUpdate">수정</button>
	<button type="button" id="btnDelete">삭제</button>

	<script>
        window.onload = function(){
            listBook();
            
            document.querySelector("#btnInsert").onclick = insertBook;
            document.querySelector("#btnUpdate").onclick = updateBook;
            document.querySelector("#btnDelete").onclick = deleteBook;
        }
        
        
        async function listBook(){
            // back-end 에 도서 목록 요청 (ajax, json)
            let url = '/books/list'
            let response = await fetch(url); // await : fetch() 종료될 때까지 기다려라.
            let data = await response.json();  // response 에 담긴 json 문자열을 javascritp ojbect 변환
            
            makeListHtml(data);
        }
        
        function makeListHtml(list){
            let listHTML = ``;
            
            list.forEach( el => {
                listHTML +=
                    `<tr data-bookId="\${el.bookId}">
                        <td>\${el.bookId}</td>
                        <td>\${el.bookName}</td>
                        <td>\${el.publisher}</td>
                        <td>\${el.price}</td>
                    </tr>`;
            });
            
            document.querySelector("#bookTbody").innerHTML = listHTML;
            
            document.querySelectorAll("#bookTbody tr").forEach( el => {
                el.onclick = function(){
                    let bookId = this.getAttribute("data-bookId");
                    detailBook(bookId);
                }
            });
        }
        
        async function detailBook(bookId){
            console.log(bookId);
            
            let url = '/books/detail/' + bookId;
            let response = await fetch(url); // await : fetch() 종료될 때까지 기다려라.
            let data = await response.json();  // response 에 담긴 json 문자열을 javascritp ojbect 변환
            
            document.querySelector("#bookId").value = data.bookId;
            document.querySelector("#bookName").value = data.bookName;
            document.querySelector("#publisher").value = data.publisher;
            document.querySelector("#price").value = data.price;
            
        }
        // post
        async function insertBook(){
            
            let urlParams = new URLSearchParams({
                bookId: document.querySelector("#bookId").value,
                bookName: document.querySelector("#bookName").value,
                publisher: document.querySelector("#publisher").value,
                price: document.querySelector("#price").value
            });
            
            let fetchOptions = {
                method: "POST",
                body: urlParams
            }
            let url = '/books/insert';
            let response = await fetch(url, fetchOptions); // await : fetch() 종료될 때까지 기다려라.
            let data = await response.json();  // response 에 담긴 json 문자열을 javascritp ojbect 변환
            
            alert("도서 등록");
            
            listBook();
        }
        
        async function updateBook(){
            
            let urlParams = new URLSearchParams({
                bookId: document.querySelector("#bookId").value,
                bookName: document.querySelector("#bookName").value,
                publisher: document.querySelector("#publisher").value,
                price: document.querySelector("#price").value
            });
            
            let fetchOptions = {
                method: "POST",
                body: urlParams
            }
            let url = '/books/update';
            let response = await fetch(url, fetchOptions); // await : fetch() 종료될 때까지 기다려라.
            let data = await response.json();  // response 에 담긴 json 문자열을 javascritp ojbect 변환
            
            alert("도서 수정");
            
            listBook();
        }
        
        async function deleteBook(){
            let bookId = document.querySelector("#bookId").value;
            let url = '/books/delete/' + bookId;
            let response = await fetch(url); // await : fetch() 종료될 때까지 기다려라.
            let data = await response.json();  // response 에 담긴 json 문자열을 javascritp ojbect 변환
            
            alert("도서 삭제");
            
            listBook();
        }
    </script>
</body>
</html>