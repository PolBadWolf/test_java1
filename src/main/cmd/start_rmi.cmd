@echo off
cls
cd ..
set ClassPath=%cd%\java\ru\pol\doctor4\test\app\remote_server1\
echo %ClassPath%
rmiregistry
