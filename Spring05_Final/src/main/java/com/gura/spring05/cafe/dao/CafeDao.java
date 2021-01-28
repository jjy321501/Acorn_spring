package com.gura.spring05.cafe.dao;

import java.util.List;

import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeDao {
	//글 추가
	public void insert(CafeDto dto);
	//글 수정
	public void update(CafeDto dto);
	//글 삭제
	public void delete(int num);
	//글 하나의 정보 얻어오기
	public CafeDto getData(int num);
	//글 목록 얻어오기
	public List<CafeDto> getList();
	//글 목록 얻어오기
	public List<CafeDto> getList(CafeDto dto);
	//글의 갯수 얻어오기
	public int  getCount();
	//글의 갯수 얻어오기(검색 키워드에 해당하는 갯수)
	public int getCount(CafeDto dto);
	
}