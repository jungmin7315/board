package com.nc13.board;

import com.nc13.board.model.entity.BoardEntity;
import com.nc13.board.repository.BoardRepository;
import com.nc13.board.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardApplicationTests {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Test
	void contextLoads() {
//		boardRepository.deleteAll();
		for(int i =1;i<=300;i++){
			BoardEntity board = BoardEntity.builder()
					.title(i+"번째 제목")
					.content(i+"번째 내용")
					.user(usersRepository.findById(2).get())
					.build()
			;
			boardRepository.save(board);
		}
	}

}
