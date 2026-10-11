# Thư viện giải phương trình bậc 2

Bài tập đóng gói lớp giải phương trình bậc 2 thành thư viện Java JAR.

## Công thức

Phương trình:

ax^2 + bx + c = 0

Delta:

delta = b^2 - 4ac

## Các trường hợp

a = 0

Không phải phương trình bậc 2.

delta < 0

Phương trình vô nghiệm thực.

delta = 0

Phương trình có nghiệm kép.

delta > 0

Phương trình có 2 nghiệm phân biệt.

## Project thư viện

quadratic-equation-lib

groupId:

com.codegym

artifactId:

quadratic-equation-lib

Class:

com.codegym.QuadraticEquationSolver

Các phương thức:

calculateDelta(double a, double b, double c)

solve(double a, double b, double c)

## Build thư viện

cd quadratic-equation-lib

mvn clean package

JAR được tạo:

target/quadratic-equation-lib-1.0-SNAPSHOT.jar

Bản JAR dùng để nộp/demo được copy vào:

dist/quadratic-equation-lib.jar

## Demo app

quadratic-equation-demo

Thư viện được copy vào:

quadratic-equation-demo/lib/quadratic-equation-lib.jar

Main.java sử dụng class QuadraticEquationSolver từ JAR.

## Chạy trên Windows

cd quadratic-equation-demo

java -cp "target\classes;lib\quadratic-equation-lib.jar" com.codegym.Main

## Test

1.

x^2 - 5x + 6 = 0

Kết quả:

x1 = 3

x2 = 2

2.

x^2 - 2x + 1 = 0

Kết quả:

x = 1

3.

x^2 + x + 1 = 0

Kết quả:

Vô nghiệm thực.

4.

a = 0

Kết quả:

IllegalArgumentException