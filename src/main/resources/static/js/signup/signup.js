$(document).ready(function(){

    $("#userinfo").addClass("tab-selected");
    $("#signup_step2").hide();
    $("#signup_step3").hide();

    $("#next1").click(function(){
        $("#signup_step1").hide();
        $("#signup_step2").show();
        $("#userinfo").removeClass("tab-selected");
        $("#companyinfo").addClass("tab-selected");
        $('html, body').animate({scrollTop: '0px'}, 300);
    });

    $("#back2").click(function(){
        $("#signup_step1").show();
        $("#signup_step2").hide();
        $("#companyinfo").removeClass("tab-selected");
        $("#userinfo").addClass("tab-selected");
        $('html, body').animate({scrollTop: '0px'}, 300);
    });

    $("#next2").click(function(){
        $("#signup_step3").show();
        $("#signup_step2").hide();
        $("#companyinfo").removeClass("tab-selected");
        $("#success").addClass("tab-selected");
        $('html, body').animate({scrollTop: '0px'}, 300);
    });
});