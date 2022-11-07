package com.voltsoft.dev.lecture.model;

import java.io.Serializable;

// 영어 공부를 할려는 'AppMember' 는 평일에는 'SalaryMan'(회사원) 이고 , 주말에는 'WeekendStudent'(주말 학원을 다니는 학생) 이다
// 영어 공부를 할려는 'AppMember' 는 화면 끼리 주고 받을 수 있는 데이터 박스 'Serializable' 이다
public class AppMember extends Human implements Serializable
{
    public String id;
    public String password;
    public String phone;
}

