function test(){
    alert("test")
}

$(document).ready(function() {
	var i=1; // 변수설정은 함수의 바깥에 설정!
  $("button").click(function() {

    $("#boxWrap").append("<div class='plus_food'>음식"+(1+i)+": &nbsp;&nbsp;&nbsp;"
                            +"<input type=text name='name' class='food_name' placeholder='이름'> &nbsp;&nbsp;&nbsp;&nbsp;"
                            +"<input type=text name='gram' class='food_g' placeholder='g'>"
                          +"</div>");

    i++; // 함수 내 하단에 증가문 설정

  });
});
