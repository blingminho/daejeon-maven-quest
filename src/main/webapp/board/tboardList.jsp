<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-fluid">
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h2 class="sub-header">게시판 목록</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>게시판 번호</th>
						<th>게시판 이름</th>
						<th>게시판 작성일자</th>
						<th>게시판 사용유무</th>
						<th>게시판 작성자아이디</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>tboard_seq</td>
						<td>tboard_title</td>
						<td>tboard_reg_dt</td>
						<td>tboard_del_yn</td>
						<td>tboard_mem_id</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>