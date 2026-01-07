# Android Naver Login & Firebase Authentication
- 안드로이드 네이버 로그인 구현
- 네이버 로그인을 Firebase Authentication 연동 구현

## Firebase Authentication 연동
Firebase Authentication 연동을 위해서는 Custom Token을 생성 해야 하는데 서버가 필요하다.  
네이버 로그인할 때 받은 `access_token`을 서버에 전달하고 서버는 firebase auth로 `auth().createCustomToken()` token을 생성해서 클라이언트에 전달한다.

## References
- [Firebase CustomToken Docs](https://firebase.google.com/docs/auth/admin/create-custom-tokens?hl=ko#android)
- [Firebase CustomToken Sample](https://github.com/FirebaseExtended/custom-auth-samples)