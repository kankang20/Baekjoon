
-- Level 2

-- 회원 ID, 상품 ID
    -- 동일한 회원이 동일한 상품을 재구매한 데이터
    -- 회원 ID를 기준으로 오름차순 정렬, 회원 ID가 같으면 상품 ID를 기준으로 내림차순
    
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
    HAVING COUNT(*) >= 2
ORDER BY USER_ID ASC, PRODUCT_ID DESC