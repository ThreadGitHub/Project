package com.coder.service;

import com.coder.service.domain.entity.User;
import com.coder.service.mapper.UserMapper;
import org.assertj.core.util.Streams;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class CoderHomeServiceApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Transactional
    @Test
    void contextLoads() {
        List<String> authority = userMapper.getAuthorityByUserId(1577243099144421378L);
        System.out.println(authority);

        authority = userMapper.getAuthorityByUserId(1577243099144421378L);
        System.out.println(authority);
    }

    public static void main(String[] args) {
        Map<String, List<User>> map = new HashMap<>();
        map.put("a", Arrays.asList(new User(), new User()));
        map.put("b", Arrays.asList(new User(), new User()));

//        List<User> users = new ArrayList<>();
//        map.values().stream().forEach(t-> users.addAll(t));

        List<User> collect = map.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect);

        List<List<User>> collect1 = map.values().stream().collect(Collectors.toList());
        Stream<List<User>> stream = Streams.stream(collect1);
    }
}
