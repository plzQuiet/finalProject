$("div").on("click", function(){

    if($(this).next("p").css("display")== "none"){

        $(this).siblings(".faq-answer").slideUp();
        $(this).next().slideDown();

    }else{
        $(this).next().slideUp();
    }
})