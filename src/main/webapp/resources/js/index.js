/**
 * 
 */
$(function(){
    $.ajax({
        url: "lista.php",
        dataType: "html",
        success: function(result){
            $("#bla").append(result);
        },
    });
});