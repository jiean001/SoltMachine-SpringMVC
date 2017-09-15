define(["jQuery", "bootstrapJs"],function ($) {
    $(document).ready(function () {
        //提示用户操作信息
        if(msg !== ""){
            $('#warning-info').html(msg);
            $(".alert-danger").show();
            setTimeout(function(){$('.alert-danger').stop().fadeOut();},3000);
        }

        //创建验证码
        createCode();
        //button事件响应
        $('.btn').on('click', illegalInput);
        $('.btn_yz').on('click', createCode);
        function illegalInput() {
            var username = $('#username').val();
            var password = $('#password').val();
            var inputCode = $('#inputCode').val();
            var checkCode = $('#checkCode').val();
            var warningInfo = "";

            //前台验证
            if($.trim(username) === ""){
                warningInfo = "用户名不能为空";
            }else if($.trim(password) === ""){
                warningInfo = "密码不能为空";
            }else if($.trim(inputCode) === ""){
                warningInfo = "验证码不能为空";
            }else if(inputCode.toUpperCase() != checkCode.toUpperCase()) { //若输入的验证码与产生的验证码不一致时
                warningInfo = "验证码输入错误！"; //则弹出验证码输入错误
                createCode(); //刷新验证码
            }

            if(warningInfo !== ""){
                //不提交表单
                $('#warning-info').html(warningInfo);
                $(".alert-danger").show();
                setTimeout(function(){$('.alert-danger').stop().fadeOut();},3000);
                return false;
            }else{
                //提交表单
                return true;   //阻止事件冒泡
            }
        }

        function createCode() {
            var code = "";
            var codeLength = 5; //验证码的长度
            var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //随机数
            for(var i = 0; i < codeLength; i++) { //循环操作
                var charIndex = Math.floor(Math.random() * 36); //取得随机数的索引
                code += random[charIndex]; //根据索引取得随机数加到code上
            }
            $('#checkCode').val(code);
        }

        //输入框操作
        function inputStatus(inputId, Class, delId) {
            $('#'+inputId).on('focus', deleteText);
            function deleteText() {
                $('.' + Class).css({'border': '1px solid #386cca'});
                var user = $('#'+inputId).val();
                if($.trim(user) !== ''){
                    $('#' + delId).css('display','block');
                }
                $('#'+inputId).on('input', function () {
                    var user = $('#'+inputId).val();
                    if($.trim(user) !== ''){
                        $('#' + delId).css('display','block');
                    }else{
                        $('#' + delId).css('display','none');
                    }
                });
            }
            $('#'+inputId).on('blur', loseFocus);
            function loseFocus() {
                $('.' + Class).css({'border':'1px solid #ccc'});
                $('#' + delId).css('display','none');
            }
            $('#' + delId).on('mousedown', close);
            function close() {
                $('#'+inputId).val(function () {
                    return "";
                });
                $(this).css('display', 'none');
            }
        }
    });
});