
신우편번호

https://www.epost.go.kr/search/zipcode/areacdAddressDown.jsp
지역별 주소 DB 다운로드 후 압축해제 한 후 data/new_area 디렉토리에 추가
구우편번호

http://www.epost.go.kr/search/zipcode/newAddressDown.jsp#
지역별 도로명주소 DB 다운로드 후 압축해제 한 후 data/old_area 디렉토리에 추가
인코딩

http://kwanseob.blogspot.kr/2013/02/zip.html
http://linuxmint.kr/tip/9119
unzip -O cp949


https://www.lesstif.com/pages/viewpage.action?pageId=14090674#GNUiconv%EB%A1%9Ccharactersetencoding%EB%B3%80%ED%99%98%ED%95%98%EA%B8%B0-CP949%EB%A1%9C%EB%90%9C%ED%95%9C%EA%B8%80%EB%AC%B8%EC%84%9C%EB%A5%BCUTF-8%EB%A1%9C%EB%B3%80%ED%99%98
iconv -f CP949 -t UTF-8 input.txt > output.txt

####################################################

https://people.apache.org/~pwendell/spark-releases/spark-2.2.0-rc1-docs/sql-programming-guide.html#parquet-files



1. 뉴 올드 각각 가져오기
2. 몇개로 맵핑해서 맵핑 테이블 생성



