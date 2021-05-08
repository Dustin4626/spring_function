SpringBoot集成Swagger
說到Swagger（絲襪哥），首先瞭解一下OpenAPI規範（OpenAPI Specification 簡稱OAS）是Linux基金會的一個專案，試圖通過定義一種用來描述API格式或API定義的語言，來規範RESTful服務開發過程，目前版本是V3.0，並且已經發佈並開源在github上。（https://github.com/OAI/OpenAPI-Specification）；
Swagger是目前最受歡迎的OpenAPI規範（OAS）開發工具框架，支援從設計和文檔到測試和部署的整個API生命週期的開發；
wagger官網：https://swagger.io/ 是一個開源項目，也就是提供jar包)；
Swagger2 版本：1.x，2.x，現在都用2.x；
Spring Boot也集成了Swagger，可以很方便地在springboot中使用Swagger生成api介面文檔；
Swagger的作用：
隨專案自動生成強大RESTful API文檔，減少開發人員工作量；（不需要自己寫api介面文檔了），使用swagger，只需要在代碼中添加一些注解即可生成API介面文檔，便於同步更新API文檔的說明，當然也有人詬病說這種方式與代碼耦合在一起，智者見智仁者見仁；
另外生成的api文檔頁面帶有測試功能，可以用來調試每個RESTful API介面
