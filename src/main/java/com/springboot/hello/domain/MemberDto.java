package com.springboot.hello.domain;

public class MemberDto {
    private String name;
    private String email;
    private String organization;

    MemberDto(String name, String email, String organization){
        this.name = name;
        this.email = email;
        this.organization = organization;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganization() {
        return organization;
    }

// 요즘은 setter를 만드는 것을 지양하는 분위기임

    @Override
    public String toString(){
        return String.format("%s %s %s", this.name, this.email, this.organization);
        
        // print가 반드시 toString을 받기 때문에 이 함수를 override해서 변경을 해주면
        // 원하는 형태로 출력할 수 있다
    }

}
