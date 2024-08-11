
-- Level 1

-- 도서 ID, 출판일
    -- 2021년에 출판된 '인문' 카테고리에 속하는 도서
    -- 출판일을 기준으로 오름차순 정렬
    
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, "%Y-%m-%d") as PUBLISHED_DATE
FROM BOOK
WHERE PUBLISHED_DATE LIKE "2021-%" AND CATEGORY = "인문"
ORDER BY PUBLISHED_DATE ASC