$('#autoComplete').autocomplete({ //id="autoComplete" 에 대한 autoComplete 메소드 수정
        source : function(request, response) { //source: 입력시 보일 목록
             $.ajax({
                   url : "/ajax/autocomplete.do" //여기에 AJAX 요청 (.do는 가상 경로)
                 , type : "POST"
                 , dataType: "JSON" // data 가 JSON 형태
                 , data : {value: request.term}	// 검색 키워드
                 , success : function(data){ 	// 성공
                     response(
                         $.map(data.resultList, function(item) {
                             return {
                                     label : item.SEARCH_WORD    	// 목록에 표시되는 값
                                   , value : item.SEARCH_WORD 		// 선택 시 input창에 표시되는 값
                                   , idx : item.SEQ // index
                             };
                         })
                     );    //response
                 } //success
                 ,error : function(){ //실패
                     alert("오류가 발생했습니다.");
                 }
             });
        }
        ,focus : function(event, ui) { // 방향키로 자동완성단어 선택 가능하게 만들어줌
                return false;
        }
        ,minLength: 1// 최소 글자수
        ,autoFocus : true // true == 첫 번째 항목에 자동으로 초점이 맞춰짐
        ,delay: 100	//autocomplete 딜레이 시간(ms)
        ,select : function(evt, ui) {
            // 아이템 선택시 실행 ui.item 이 선택된 항목을 나타내는 객체, lavel/value/idx를 가짐
                console.log(ui.item.label); //로그남기기
                console.log(ui.item.idx); //로그남기기
         }
});

$(document).ready(function() {
	var i=1; // 변수설정은 함수의 바깥에 설정!
  $("button").click(function() {

    $("#boxWrap").append("<div class='plus_food'>음식"+(1+i)+": &nbsp;&nbsp;&nbsp;"
                            +"<input type=text name='name' class='food_name' id='autoComplete' placeholder='이름'> &nbsp;&nbsp;&nbsp;&nbsp;"
                            +"<input type=text name='gram' class='food_g' placeholder='g'>"
                          +"</div>");
    i++; // 함수 내 하단에 증가문 설정

    $("input#autoComplete").focus();

  });

});

$(document).on("focus","input#autoComplete",function(){
    $(this).autocomplete({ //id="autoComplete" 에 대한 autoComplete 메소드 수정
                                 source : function(request, response) { //source: 입력시 보일 목록
                                      $.ajax({
                                            url : "/ajax/autocomplete.do" //여기에 AJAX 요청 (.do는 가상 경로)
                                          , type : "POST"
                                          , dataType: "JSON" // data 가 JSON 형태
                                          , data : {value: request.term}	// 검색 키워드
                                          , success : function(data){ 	// 성공
                                              response(
                                                  $.map(data.resultList, function(item) {
                                                      return {
                                                              label : item.SEARCH_WORD    	// 목록에 표시되는 값
                                                            , value : item.SEARCH_WORD 		// 선택 시 input창에 표시되는 값
                                                            , idx : item.SEQ // index
                                                      };
                                                  })
                                              );    //response
                                          } //success
                                          ,error : function(){ //실패
                                              alert("오류가 발생했습니다.");
                                          }
                                      });
                                 }
                                 ,focus : function(event, ui) { // 방향키로 자동완성단어 선택 가능하게 만들어줌
                                         return false;
                                 }
                                 ,minLength: 1// 최소 글자수
                                 ,autoFocus : true // true == 첫 번째 항목에 자동으로 초점이 맞춰짐
                                 ,delay: 100	//autocomplete 딜레이 시간(ms)
                                 ,select : function(evt, ui) {
                                     // 아이템 선택시 실행 ui.item 이 선택된 항목을 나타내는 객체, lavel/value/idx를 가짐
                                         console.log(ui.item.label); //로그남기기
                                         console.log(ui.item.idx); //로그남기기
                                  }
                         }); //ajax 연결이 안됨
})