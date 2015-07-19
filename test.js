$(document).ready(function() {
  var pick = window.getSelection() || document.getSelection();
  $('p').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") { console.log(word) }
    event.stopPropagation();
  });
  $('h1').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") { console.log(word) }
    event.stopPropagation();
  });
  $('h2').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") { console.log(word) }
    event.stopPropagation();
  });
  $('h3').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") { console.log(word) }
    event.stopPropagation();
  });
  $('h4').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") { console.log(word) }
    event.stopPropagation();
  });
  $('h5').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") { console.log(word) }
    event.stopPropagation();
  });
  $('h6').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if(word !== "") { console.log(word) }
    event.stopPropagation();
  });
});
