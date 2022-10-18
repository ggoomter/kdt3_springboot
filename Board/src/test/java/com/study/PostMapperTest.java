package com.study;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.domain.post.PostMapper;
import com.study.domain.post.PostRequest;
import com.study.domain.post.PostResponse;

@SpringBootTest
public class PostMapperTest {

    @Autowired
    PostMapper postMapper;

    @Test
    void save() {
        PostRequest params = new PostRequest();
        /* 1. 데이터 준비 */
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        
        /* 2. 테스트 실행 */
        postMapper.save(params);

        /* 3. 테스트 결과 활용 */
        List<PostResponse> posts = postMapper.findAll();
        System.out.println("전체 게시글 개수는 : " + posts.size() + "개입니다.");
    }

}