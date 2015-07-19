var myapp = angular.module("Eloqui", []);

myapp.controller('MainCtrl', ['$scope',
    function ($scope) {
      console.log("hello");
    }
]);

$(document).ready(function() {
  var word="";
  var lang = 'eng';

  $('#language').change(function(){
    lang = $('input:radio[name=language]:checked').val();
    console.log(lang);
  });
  var wordArray=[];
  var pick = document.getSelection() || window.getSelection();
  $('p').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") {
      $.ajax('https://glosbe.com/gapi/translate?from='+ lang +'&dest=eng&format=json&phrase=' + word, {
        dataType: 'JSONP'
      }).success(function(response) {
        if(wordArray.indexOf(word) > -1) {
          $('#definition span').each(function(){
            if (word === $(this).html())
            $(this).addClass('highlight');
          });
        };
        if (wordArray.indexOf(word) === -1){
          wordArray.push(word);
          var definition = response.tuc[0].meanings[0].text;
          $('#definition').prepend("<span id='word'>" + word + "</span>" + " : " + definition + "<br>");
          console.log(definition);
        };
      });
    }
  });
  $('h1').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") {
      $.ajax('https://glosbe.com/gapi/translate?from='+ lang +'&dest=eng&format=json&phrase=' + word, {
        dataType: 'JSONP'
      }).success(function(response) {
        if(wordArray.indexOf(word) > -1) {
          $('#word').each(function(){
            if (word === $(this).html())
            $(this).addClass('highlight');
          });
        };
        if (wordArray.indexOf(word) === -1){
          wordArray.push(word);
          var definition = response.tuc[0].meanings[0].text;
          $('#definition').prepend("<span id='word'>" + word + "</span>" + " : " + definition + "<br>");
          console.log(definition);
        };
      });
    }
  });
  $('h2').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") {
      $.ajax('https://glosbe.com/gapi/translate?from='+ lang +'&dest=eng&format=json&phrase=' + word, {
        dataType: 'JSONP'
      }).success(function(response) {
        if(wordArray.indexOf(word) > -1) {
          $('#word').each(function(){
            if (word === $(this).html())
            $(this).addClass('highlight');
          });
        };
        if (wordArray.indexOf(word) === -1){
          wordArray.push(word);
          var definition = response.tuc[0].meanings[0].text;
          $('#definition').prepend("<span id='word'>" + word + "</span>" + " : " + definition + "<br>");
          console.log(definition);
        };
      });
    }
  });
  $('h3').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") {
      $.ajax('https://glosbe.com/gapi/translate?from='+ lang +'&dest=eng&format=json&phrase=' + word, {
        dataType: 'JSONP'
      }).success(function(response) {
        if(wordArray.indexOf(word) > -1) {
          $('#word').each(function(){
            if (word === $(this).html())
            $(this).addClass('highlight');
          });
        };
        if (wordArray.indexOf(word) === -1){
          wordArray.push(word);
          var definition = response.tuc[0].meanings[0].text;
          $('#definition').prepend("<span id='word'>" + word + "</span>" + " : " + definition + "<br>");
          console.log(definition);
        };
      });
    }
  });
  $('h4').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") {
      $.ajax('https://glosbe.com/gapi/translate?from='+ lang +'&dest=eng&format=json&phrase=' + word, {
        dataType: 'JSONP'
      }).success(function(response) {
        if(wordArray.indexOf(word) > -1) {
          $('#word').each(function(){
            if (word === $(this).html())
            $(this).addClass('highlight');
          });
        };
        if (wordArray.indexOf(word) === -1){
          wordArray.push(word);
          var definition = response.tuc[0].meanings[0].text;
          $('#definition').prepend("<span id='word'>" + word + "</span>" + " : " + definition + "<br>");
          console.log(definition);
        };
      });
    }
  });
  $('h5').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") {
      $.ajax('https://glosbe.com/gapi/translate?from='+ lang +'&dest=eng&format=json&phrase=' + word, {
        dataType: 'JSONP'
      }).success(function(response) {
        if(wordArray.indexOf(word) > -1) {
          $('#word').each(function(){
            if (word === $(this).html())
            $(this).addClass('highlight');
          });
        };
        if (wordArray.indexOf(word) === -1){
          wordArray.push(word);
          var definition = response.tuc[0].meanings[0].text;
          $('#definition').prepend("<span id='word'>" + word + "</span>" + " : " + definition + "<br>");
          console.log(definition);
        };
      });
    }
  });
  $('h6').dblclick(function(event) {
    var word = $.trim(pick.toString().toLowerCase());
    if (word !== "") {
      $.ajax('https://glosbe.com/gapi/translate?from='+ lang +'&dest=eng&format=json&phrase=' + word, {
        dataType: 'JSONP'
      }).success(function(response) {
        if(wordArray.indexOf(word) > -1) {
          $('#word').each(function(){
            if (word === $(this).html())
            $(this).addClass('highlight');
          });
        };
        if (wordArray.indexOf(word) === -1){
          wordArray.push(word);
          var definition = response.tuc[0].meanings[0].text;
          $('#definition').prepend("<span id='word'>" + word + "</span>" + " : " + definition + "<br>");
          console.log(definition);
        };
      });
    }
  });
});
