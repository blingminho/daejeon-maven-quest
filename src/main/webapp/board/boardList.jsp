<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-fluid">
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h2 class="sub-header">게시판 제목(tboard_title2)</h2>
		
		<select id="tboardSelect">
			<option value="tboard_seq1">tboard_title1</option>
			<option value="tboard_seq2">tboard_title2</option>
		</select>
		<button type="button" id="changeTboard" class="btn btn-sm btn-primary">게시판 이동</button>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>등록일자</th>
						<th>글쓴이</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>test</td>
						<td>test1</td>
						<td>test2</td>
						<td>test3</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>