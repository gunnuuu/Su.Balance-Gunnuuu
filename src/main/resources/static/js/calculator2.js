// 음식 추가하는 함수
function plusFood(){
   var result="";
   result+= "<div class="plus_food">"
		+음식1: &nbsp;&nbsp;&nbsp;"
		+<input type=text name="name" class="food_name" placeholder="이름"> &nbsp;&nbsp;&nbsp;&nbsp;"
		+"<input type=text name="gram" class="food_g" placeholder="g">"
		+</div>"
}


function createDIV(){
    obj = document.getElementById("food_calculator");
    newDiv = document.createElement("div");
    newDiv.innerHTML = "새로 생성된 DIV입니다. 누르면 삭제 됩니다.";
    newDiv.setAttribute("id", "myDiv"); // 새롭게 만들어지는 div 태그에 id 값 저장

    // 익명 함수 : 바로 그 이벤트를 실행하기위해 이름을 정하지 않고 바로실행
    newDiv.onclick = function(){
        p = this.parentElement; //부모 HTML 태그요소
        p.removeChild(this); // 자신을 부모 태그로 부터 제거
    }

    obj.appendChild(newDiv);
 }

 function test(){
    alert("test");
 }