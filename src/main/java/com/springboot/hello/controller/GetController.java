package com.springboot.hello.controller;

import com.springboot.hello.domain.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
@Slf4j
public class GetController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){

        log.info("hello로 요청이 들어왔습니다");
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName(){

        log.info("getName으로 요청이 들어왔습니다."); // reponse가 완료되면 로그가 남음
        return "Kyeongrok";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        log.info("getVariable1으로 요청이 들어왔습니다. variable: {}", variable);
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String str){
        return str;
    }
    // 맞추기 어려울 때 @PathVariable에 파라미터의 이름을 적으면 됩니다


    @GetMapping(value = "/request1")
    public void getRequestParam1(@RequestParam String name, @RequestParam String email, @RequestParam String organization){
        System.out.println(String.format("%s %s %s", name, email, organization));

        //return ;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        param.entrySet().forEach(map -> {
            System.out.printf("key:%s value:%s\n", map.getKey(), map.getValue());
        } );

        return "request2가 호출 완료 되었습니다";
        // Java8의 Stream 형식
        //(mpa -> {}) 이 부분이 메소드의 형식이라고 생각하면 됨
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        System.out.println(memberDto);
        // return "request3 호출 완료";
        return memberDto.toString();
    }

//    @ApiOperation(value = "Get 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
//    @GetMapping(value = "request1")
//    public String getRequestParam(
//            @ApiParam(value="이름", required = true) @RequestParam String name,
//
//    );


}
