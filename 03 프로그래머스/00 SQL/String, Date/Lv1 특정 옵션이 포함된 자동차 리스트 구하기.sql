
-- Level 1

-- 자동차의 모든 정보
    -- 네비게이션 옵션이 포함된 자동차
    -- 자동차 ID를 기준으로 내림차순

SELECT CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE "%네비게이션%"
ORDER BY CAR_ID DESC
