配置中心
    encrypt加密：
        1.把jdk下面 /jre/lib/security 目录下面的两个jar替换了。
        2.使用keytool -genkeypair -alias cc-alias -keyalg RSA -dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=ZH" -keypass cc-secret -keystore server.jks -storepass cc-password
        在命令窗口下生产加密Key
        3.使用postman访问localhost:port/encrypt -d mysecret 可以加密字符
        4.使用postman访问localhost:port/decrypt -d 682bc583f4641835fa2db009355293665d2647dade3375c0ee201de2a49f7bda 可以解密字符
