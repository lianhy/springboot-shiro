function login(){
    $.ajax({
        url:'/login.do',
        type:'post',
        data:$('#loginForm').serialize(),
        dataType:'json',
        success:function(res){
            window.location.href="/greeting"
        }
    })
}