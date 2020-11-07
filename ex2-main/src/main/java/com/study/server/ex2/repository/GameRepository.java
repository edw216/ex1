package com.study.server.ex2.repository;

import com.study.server.ex2.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Integer> {
}
