package com.study;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.study.domain.post.PostRequest;
import com.study.domain.post.PostService;

@SpringBootTest
public class PostServiceTest {

	@Autowired
    PostService postService;

    @Test
    void save() {
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 Junit  Service 테스트 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        Long newPostId = postService.savePost(params);
        System.out.println("생성된 게시글 ID : "+newPostId);
    }
    
    @Test
    @Transactional
	public void registerBoard() {
    	//1. 데이터 준비
    	PostRequest params = new PostRequest();
    	params.setTitle("트랜잭션 테스트 제목");
    	params.setContent("트랜잭션 내용");
    	params.setWriter("트랜잭터");
    	params.setNoticeYn(false);
    	System.out.println("테스트 데이터 준비됨");

    	//2. 테스트 실행
		postService.savePost(params);	//글삽입 또는 수정
		System.out.println("글 삽입 또는 수정 함수 실행됨33");
		
		//3. 테스트결과 활용
		//의도적으로 널로 바꾼다음 에러 터지게함
		//params = null;
		//System.out.println("의도적 null뒤 : "+params.getTitle());	//널포인트 익셉션 터짐

	}
}
