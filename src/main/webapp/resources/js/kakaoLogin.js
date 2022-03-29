let token = $("input[name='_csrf']").val();
let header = "X-CSRF-TOKEN";

$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});

$.ajaxSetup({
    error: function (xhr, status, err) {
        if (xhr.status == 401) {
            alert("잘못된 접근입니다. 로그인 페이지로 이동합니다.");
            location.href = "/login";
        } else if (xhr.status == 403) {
            alert("잘못된 접근입니다. 로그인 페이지로 이동합니다.");
            location.href = "/login";
        }
    }
});

Kakao.init('069ef3e06b0e566cf2942328aa13f94e'); //발급받은 키 중 javascript키를 사용해준다.

kakaoLogout(); // 로그인 페이지 접속시 로그아웃 시켜준다

//카카오로그인
function kakaoLogin() {

    Kakao.Auth.login({
        success: function (response) {

            Kakao.API.request({
                url: '/v2/user/me',
                success: function (response) {

                    console.log(response);

                    let email = response.kakao_account.email ;
                    let kakaoId = response.id;
                    let profile= response.properties.profile_image;
                    let birthday = response.kakao_account.birthday;

                    if(email == '' || email == undefined){
                        alert("전체 동의하기 또는 카카오계정(이메일)을 필수 선택해주세요")
                        kakaoLogout();
                    }else{
                        responseSuccessLogin(email, kakaoId, profile, birthday);
                    }
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

function responseSuccessLogin(email, kakaoId, profile, birthday) {

    $.ajax({

        type: 'POST',
        url: 'kakao/sns/login',
        data: {
            "email": email,
            "kakaoId": kakaoId,
            "profile": profile,
            "birthday" : birthday
        },
        // @RestController에서 받은 리턴타입인 Signdms - Sign에대한 정보 모두 받음
        // 만약 넘겨줄게 email만 있다면 String으로 리턴 타입 써주어도 된다.
        success: function(response) { //이메일 한개만 넘어갔으니 response자체가 이메일임 //만약 sign으로 넘겼다면 response.email

            console.log(response);
            // 로그인
            location.href = "/";
        },
        fail: function(error) {

        },
    })

}
