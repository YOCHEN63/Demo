-- 创建用户表
CREATE TABLE IF NOT EXISTS user (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,   -- 用户ID，主键，自增
                                    username VARCHAR(100) NOT NULL,         -- 用户名
                                    email VARCHAR(100) NOT NULL,            -- 邮箱
                                    password VARCHAR(255) NOT NULL,         -- 密码
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 用户创建时间
                                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- 用户更新时间
);

-- 创建产品表
CREATE TABLE IF NOT EXISTS product (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,   -- 产品ID，主键，自增
                                       name VARCHAR(100) NOT NULL,             -- 产品名
                                       description TEXT,                       -- 产品描述
                                       price DECIMAL(10, 2) NOT NULL,          -- 产品价格
                                       stock_quantity INT NOT NULL,
                                       user_id BIGINT NOT NULL,                -- 关联的用户ID
                                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 产品创建时间
                                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 产品更新时间
);
