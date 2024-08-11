
-- Level 2

-- 만원 단위의 가격대 별 상품 개수
    -- 가격대 정보는 각 구간의 최소 금액으로 표현
    -- 가격대를 기준으로 오름차순 정렬

SELECT 10000 * (PRICE DIV 10000) AS PRICE_GROUP, COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP