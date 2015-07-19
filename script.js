$("word").click(function() {
  $.ajax({
    url: "http://www.dictionaryapi.com/api/v1/references/collegiate/xml/test?key=c35a1e50-84a7-4ccd-9715-5c353f1e7adf",
    type: "GET",
    dataType: "jsonp",  //For external apis
    data: data,
    success: function() {
       alert("success") },
  });
});
