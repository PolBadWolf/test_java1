@echo off
cls
cd ..\..\..
rem set CLASSPATH=%cd%\target\classes\ru\pol\doctor4\test\app\remote_server1\
set CLASSPATH=C:\Users\nmGumerov\.m2\repository\ru\polbadwolf\test1\test_java1_interface1\1.0\test_java1_interface1-1.0.jar
echo %ClassPath%
rmiregistry &
