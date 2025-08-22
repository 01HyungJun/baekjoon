-- 코드를 입력하세요
SELECT * 
FROM (
    SELECT 
        A.car_id, 
        A.car_type, 
        A.daily_fee * 30 * (1 - B.discount_rate / 100) AS FEE
    FROM 
        (SELECT * 
         FROM CAR_RENTAL_COMPANY_CAR 
         WHERE CAR_TYPE IN ('세단', 'SUV')) A,
        (SELECT CAR_TYPE, DISCOUNT_RATE 
         FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
         WHERE DURATION_TYPE = '30일 이상') B
    WHERE 
        A.CAR_TYPE = B.CAR_TYPE
        AND A.CAR_ID NOT IN (
            SELECT CAR_ID 
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
            WHERE END_DATE > DATE '2022-11-01' 
              AND START_DATE <= DATE '2022-11-30'
        )
)
WHERE 
    FEE >= 500000 
    AND FEE < 2000000;