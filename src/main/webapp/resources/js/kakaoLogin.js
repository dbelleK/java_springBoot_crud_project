

Kakao.init('069ef3e06b0e566cf2942328aa13f94e'); //발급받은 키 중 javascript키를 사용해준다.

kakaoLogout(); // 로그인 페이지 접속시 로그아웃 시켜준다

//카카오로그인
function kakaoLogin() {

    Kakao.Auth.login({
        success: function (response) {

            Kakao.API.request({
                url: '/v2/user/me',
                success: function (response) {
                    let email = response.kakao_account.email ;
                    let kakaoId = response.id;

                    if(email == '' || email == undefined){
                        alert("전체 동의하기 또는 카카오계정(이메일)을 필수 선택해주세요")
                        kakaoLogout();
                    }else{
                        responseSuccessLogin(email, kakaoId);
                    }


                    console.log(response)
                },
                fail: function (error) {
                    console.log(error)
                },
            })
        },

        fail: function (error) {
            console.log(error)
        },
    })
}
//카카오로그아웃
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
        Kakao.API.request({
            url: '/v1/user/unlink',
            success: function (response) {
                console.log(response)
            },
            fail: function (error) {
                console.log(error)
            },
        })
        Kakao.Auth.setAccessToken(undefined)
    }
}

function responseSuccessLogin(email, kakaoId) {

    $.ajax({

        type: 'POST',
        url: 'kakao/sns/login',
        data: {
            "email": email,
            "kakaoId": kakaoId
        },
        success: function(response) {

            // 로그인
            location.href = "/loginBykakao?email="+response.email;
        },
        fail: function(error) {

        },
    })

}
