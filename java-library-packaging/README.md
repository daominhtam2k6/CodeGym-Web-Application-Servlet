# Đóng gói thư viện Java

Bài thực hành gồm 2 Maven project.

## 1. math-lib

groupId:

com.codegym

artifactId:

math-lib

Class:

com.codegym.Calculator

Các phương thức static:

sum(int a, int b)

sub(int a, int b)

mul(int a, int b)

divide(int a, int b)

divide() ném:

java.security.NoSuchAlgorithmException

khi b = 0.

Build:

mvn clean package

Kết quả:

math-lib/target/math-lib-1.0-SNAPSHOT.jar

## 2. calculator-app

Đây là project riêng sử dụng JAR vừa build.

JAR được copy thành:

calculator-app/lib/math-lib.jar

pom.xml khai báo dependency bằng:

scope system

systemPath:

${project.basedir}/lib/math-lib.jar

Main class:

com.codegym.Main

## Chạy trên Windows

Tại calculator-app:

java -cp "target\classes;lib\math-lib.jar" com.codegym.Main

Windows sử dụng dấu chấm phẩy ; để phân cách classpath.

macOS/Linux sử dụng dấu hai chấm :.

## Kết quả mong đợi

Tong 2 so (5, 9): 14

Hieu 2 so (5, 9): -4

Tich 2 so (5, 9): 45

Thuong 2 so (10, 5): 2

## Test chia cho 0

Có thể bỏ comment đoạn:

Calculator.divide(10, 0)

để kiểm tra NoSuchAlgorithmException.