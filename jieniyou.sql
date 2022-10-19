/*
 Navicat Premium Data Transfer

 Source Server         : 小敏_XiaoMin
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : jieniyou

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 17/10/2022 09:08:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address`  (
  `address_id` int NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '地址信息',
  `address_street` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '详细地址',
  `postal_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '邮政编码',
  `consignee_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '收货人姓名',
  `address_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '手机号',
  `address_status` int NOT NULL DEFAULT 1 COMMENT '地址状态',
  PRIMARY KEY (`address_id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES (1, 1001, '四川省/南充市/仪陇县', '大风乡', '637600', '解你忧', '18383082805', 1);
INSERT INTO `tb_address` VALUES (2, 1001, '四川省/成都市/双流区', '万科云城10栋', '000000', '解你忧', '18383082805', 1);
INSERT INTO `tb_address` VALUES (3, 1001, '四川省/成都市/双流区', '四川省成都市双流区鲲鹏生态(讯方)公司', '000000', '解你忧', '18383082805', 1);
INSERT INTO `tb_address` VALUES (4, 8265209753713631232, '四川省/南充市/仪陇县', '日兴镇', '637600', '蔡林权', '13659053829', 1);
INSERT INTO `tb_address` VALUES (27, 1001, '北京市/市辖区/东城区', '123', '000000', '林敏', '13434343444', 0);
INSERT INTO `tb_address` VALUES (28, 8261606279743553536, '北京市/市辖区/东城区', '123', '000000', '林敏', '13434343433', 0);
INSERT INTO `tb_address` VALUES (29, 8261606279743553536, '天津市/市辖区/河东区', '123', '111111', '林敏', '13434343433', 0);
INSERT INTO `tb_address` VALUES (30, 1001, '北京市/市辖区/东城区', '122', '125688', '林敏', '18888999965', 0);
INSERT INTO `tb_address` VALUES (31, 1001, '北京市/市辖区/西城区', '132', '123456', '林敏', '18383000000', 0);
INSERT INTO `tb_address` VALUES (32, 8269452192292921344, '北京市/市辖区/西城区', 'rfg', '323444', '林敏', '13435555555', 1);
INSERT INTO `tb_address` VALUES (33, 1001, '天津市/市辖区/河西区', 'ui粉红色', '132222', '林敏', '13555555544', 0);
INSERT INTO `tb_address` VALUES (34, 1001, '天津市/市辖区/河西区', '234', '324432', '林敏', '18383082805', 1);
INSERT INTO `tb_address` VALUES (35, 8269460511841705984, '北京市/市辖区/西城区', '234', '234234', '林敏', '15858585858', 1);

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员密码',
  `identity` bit(1) NOT NULL DEFAULT b'0' COMMENT '管理员身份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES (1, '解你忧', '1314520linmin', b'1');

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '手机类别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES (1, '三星集团');
INSERT INTO `tb_category` VALUES (2, '步步高');
INSERT INTO `tb_category` VALUES (3, '华为技术有限公司');
INSERT INTO `tb_category` VALUES (4, '广东欧珀移动通信有限公司');
INSERT INTO `tb_category` VALUES (5, '苹果公司');
INSERT INTO `tb_category` VALUES (6, '魅族科技有限公司');
INSERT INTO `tb_category` VALUES (7, '小米科技有效责任公司');
INSERT INTO `tb_category` VALUES (8, '锤子科技');

-- ----------------------------
-- Table structure for tb_color
-- ----------------------------
DROP TABLE IF EXISTS `tb_color`;
CREATE TABLE `tb_color`  (
  `color_id` int NOT NULL AUTO_INCREMENT COMMENT '颜色id',
  `phone_color` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '颜色',
  PRIMARY KEY (`color_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_color
-- ----------------------------
INSERT INTO `tb_color` VALUES (1, '梦幻白');
INSERT INTO `tb_color` VALUES (2, '馥郁红');
INSERT INTO `tb_color` VALUES (3, '石墨黑');
INSERT INTO `tb_color` VALUES (4, '秘银色');
INSERT INTO `tb_color` VALUES (5, '蓝色');
INSERT INTO `tb_color` VALUES (6, '鸢尾紫');

-- ----------------------------
-- Table structure for tb_information
-- ----------------------------
DROP TABLE IF EXISTS `tb_information`;
CREATE TABLE `tb_information`  (
  `id` int NOT NULL COMMENT '手机Id',
  `category_id` bigint NULL DEFAULT NULL COMMENT '手机类别',
  `phone_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机型号',
  `phone_cpu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机cpu型号',
  `phone_price` double(10, 2) NULL DEFAULT NULL COMMENT '手机价格',
  `phone_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/iphone-card-40-iphone14pro-202209?wid=340&hei=264&fmt=p-jpg&qlt=95&.v=1663611329492' COMMENT '手机图片',
  `phone_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE,
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `tb_category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_information
-- ----------------------------
INSERT INTO `tb_information` VALUES (1, 1, 'Galaxy S22', '骁龙 8 Gen1', 5799.00, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', '超窄屏幕边框与机身金属边框流畅过渡，带来平衡悦目视效。作为时尚外观的点睛之笔，后置摄像头由亮眼同色的金属模组外框保护，轮廓设计具超高辨识度。');
INSERT INTO `tb_information` VALUES (2, 2, 'IQOO 10', '骁龙8+', 4899.00, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', '首发量产200W 超快闪充 高性能旗舰iQOO 10系列发布');
INSERT INTO `tb_information` VALUES (3, 3, 'Mate 50', '骁龙8+', 6299.00, 'https://consumer.huawei.com/content/dam/huawei-cbg-site/cn/mkt/pdp/phones/mate50/img/kv/kv@2x.webp', '承袭 Mate 家族标志性对称基因，融入巴黎饰钉设计理念，秩⁠序之美和非凡细节交相辉映。昆仑破晓，划⁠破苍穹；昆仑霞⁠光，普照万山；冰霜银、曜金黑、流光紫，映见宇宙的神秘与未⁠知。');
INSERT INTO `tb_information` VALUES (4, 4, 'Find X5 ', '骁龙 888', 5999.00, 'https://www.oppo.com/content/dam/oppo/product-asset-library/find/find-x5-series/find-x5/cn/v1/assets/phone-black-luwu-e887b5.png.webp', 'OPPO 首颗自研影像专用 NPU 芯片，算力强、功耗低，针对图像原始信息进行实时 AI 降噪与 HDR 融合，打造细节清晰、层次丰富、色彩准确的拍摄效果。');
INSERT INTO `tb_information` VALUES (5, 5, '14 Pro Max', 'A16', 10992.00, 'https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/iphone-card-40-iphone14pro-202209?wid=340&hei=264&fmt=p-jpg&qlt=95&.v=1663611329492', '新增全天候显示、首度登陆 iPhone 的 4800 万像素摄像头、车祸检测，并可通过灵动岛以创新方式接收通知和活动');
INSERT INTO `tb_information` VALUES (6, 6, '18S Pro', '骁龙 888+', 2599.00, 'https://fms.res.meizu.com/dms/2021/09/22/652a6675-bb4c-451d-ba00-9f1dad100721.jpg', '全新升级的高通骁龙 888+ 年度旗舰移动平台，超大核 3.0 GHz 主频 5nm 制程让性能更进一步');
INSERT INTO `tb_information` VALUES (7, 7, 'Mix Fold 2', '骁龙8+', 9058.00, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', '以创新科技\r\n打造一份「薄礼」');
INSERT INTO `tb_information` VALUES (8, 8, '坚果 R2', '骁龙865', 1469.00, 'https://resource.smartisan.com/resource/4d9e7683b590cf4a6996d3b13136bcf8.png?x-oss-process=image/resize,w_216/format,webp', '是下一代手机，更是下一代电脑\r\n');

-- ----------------------------
-- Table structure for tb_member
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `member_id` bigint NOT NULL COMMENT '会员id',
  `member_level` int NOT NULL COMMENT '会员等级',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `member_level`(`member_level` ASC) USING BTREE,
  INDEX `menber_id`(`member_id` ASC) USING BTREE,
  CONSTRAINT `member_level` FOREIGN KEY (`member_level`) REFERENCES `tb_member_level` (`level_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `menber_id` FOREIGN KEY (`member_id`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_member
-- ----------------------------
INSERT INTO `tb_member` VALUES (1, 1001, 6);
INSERT INTO `tb_member` VALUES (2, 1002, 5);

-- ----------------------------
-- Table structure for tb_member_level
-- ----------------------------
DROP TABLE IF EXISTS `tb_member_level`;
CREATE TABLE `tb_member_level`  (
  `level_id` int NOT NULL AUTO_INCREMENT COMMENT '等级编号',
  `member_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT 'vip 1:青铜' COMMENT '等级名称',
  `member_discount` decimal(10, 2) NOT NULL COMMENT '等级折扣',
  PRIMARY KEY (`level_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_member_level
-- ----------------------------
INSERT INTO `tb_member_level` VALUES (1, 'vip 1:青铜', 0.99);
INSERT INTO `tb_member_level` VALUES (2, 'vip 2:白银', 0.98);
INSERT INTO `tb_member_level` VALUES (3, 'vip 3:黄金', 0.95);
INSERT INTO `tb_member_level` VALUES (4, 'vip 1:铂金', 0.80);
INSERT INTO `tb_member_level` VALUES (5, 'vip 5:钻石', 0.70);
INSERT INTO `tb_member_level` VALUES (6, 'vip 6:至尊', 0.55);

-- ----------------------------
-- Table structure for tb_ms
-- ----------------------------
DROP TABLE IF EXISTS `tb_ms`;
CREATE TABLE `tb_ms`  (
  `ms_id` int NOT NULL AUTO_INCREMENT COMMENT '内存及信号Id',
  `ms_memory` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内存',
  `ms_signals` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '信号',
  PRIMARY KEY (`ms_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_ms
-- ----------------------------
INSERT INTO `tb_ms` VALUES (1, '8GB+128GB', '5G全网通');
INSERT INTO `tb_ms` VALUES (2, '8GB+256GB', '5G全网通');
INSERT INTO `tb_ms` VALUES (3, '8GB+512GB', '5G全网通');
INSERT INTO `tb_ms` VALUES (4, '8GB+512GB', '4G全网通');
INSERT INTO `tb_ms` VALUES (5, '12GB+256GB', '5G全网通');
INSERT INTO `tb_ms` VALUES (7, '8GB+1T', '5G全网通');
INSERT INTO `tb_ms` VALUES (8, '16GB+512', '5G全网通');
INSERT INTO `tb_ms` VALUES (9, '8GB+128GB', '4G全网通');

-- ----------------------------
-- Table structure for tb_mycart_sidebar
-- ----------------------------
DROP TABLE IF EXISTS `tb_mycart_sidebar`;
CREATE TABLE `tb_mycart_sidebar`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '我的初心',
  `mycart_sidebar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '侧边栏列表',
  `mycart_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '/' COMMENT 'item地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_mycart_sidebar
-- ----------------------------
INSERT INTO `tb_mycart_sidebar` VALUES (1, '我的购物车', '/ShoppingCart');
INSERT INTO `tb_mycart_sidebar` VALUES (2, '已买到的宝贝', '/HasTaked');
INSERT INTO `tb_mycart_sidebar` VALUES (3, '钱包', '/WalletPage');

-- ----------------------------
-- Table structure for tb_origin
-- ----------------------------
DROP TABLE IF EXISTS `tb_origin`;
CREATE TABLE `tb_origin`  (
  `origin_id` int NOT NULL AUTO_INCREMENT COMMENT '生产地Id',
  `category_origin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生产地',
  PRIMARY KEY (`origin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_origin
-- ----------------------------
INSERT INTO `tb_origin` VALUES (1, '中国');
INSERT INTO `tb_origin` VALUES (2, '美国');
INSERT INTO `tb_origin` VALUES (3, '韩国');

-- ----------------------------
-- Table structure for tb_phone_color_ms_origin
-- ----------------------------
DROP TABLE IF EXISTS `tb_phone_color_ms_origin`;
CREATE TABLE `tb_phone_color_ms_origin`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '手机与颜色id',
  `phone_id` int NULL DEFAULT NULL COMMENT '手机id',
  `color_id` int NULL DEFAULT NULL COMMENT '颜色id',
  `ms_id` int NULL DEFAULT NULL COMMENT '手机ms',
  `origin_id` int NULL DEFAULT NULL COMMENT '手机生源地',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `phoneId`(`phone_id` ASC) USING BTREE,
  INDEX `colorId`(`color_id` ASC) USING BTREE,
  INDEX `msId`(`ms_id` ASC) USING BTREE,
  INDEX `originId`(`origin_id` ASC) USING BTREE,
  CONSTRAINT `colorId` FOREIGN KEY (`color_id`) REFERENCES `tb_color` (`color_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `msId` FOREIGN KEY (`ms_id`) REFERENCES `tb_ms` (`ms_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `originId` FOREIGN KEY (`origin_id`) REFERENCES `tb_origin` (`origin_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `phoneId` FOREIGN KEY (`phone_id`) REFERENCES `tb_information` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_phone_color_ms_origin
-- ----------------------------
INSERT INTO `tb_phone_color_ms_origin` VALUES (1, 1, 1, 1, 1);
INSERT INTO `tb_phone_color_ms_origin` VALUES (2, 2, 2, 2, 2);
INSERT INTO `tb_phone_color_ms_origin` VALUES (3, 3, 3, 2, 1);
INSERT INTO `tb_phone_color_ms_origin` VALUES (4, 4, 4, 3, 1);
INSERT INTO `tb_phone_color_ms_origin` VALUES (5, 5, 1, 4, 1);
INSERT INTO `tb_phone_color_ms_origin` VALUES (6, 6, 6, 2, 1);
INSERT INTO `tb_phone_color_ms_origin` VALUES (7, 7, 6, 5, 1);
INSERT INTO `tb_phone_color_ms_origin` VALUES (8, 8, 5, 1, 1);

-- ----------------------------
-- Table structure for tb_shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `tb_shopping_cart`;
CREATE TABLE `tb_shopping_cart`  (
  `shoppingcart_id` int NOT NULL AUTO_INCREMENT COMMENT '购物id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `goods_id` int NOT NULL COMMENT '物品id',
  `address_id` int NOT NULL COMMENT '地址id',
  `goods_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '物品图片',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '物品名称',
  `goods_price` decimal(10, 2) NOT NULL COMMENT '物品单价',
  `goods_number` int NOT NULL COMMENT '物品数量',
  `goods_total_price` decimal(10, 2) NOT NULL COMMENT '总价格',
  `goods_pay_status` int NOT NULL DEFAULT 0 COMMENT '是否付款0未1已',
  `goods_take_status` int NOT NULL DEFAULT 0 COMMENT '是否取货',
  `goods_delivery_status` int NOT NULL DEFAULT 0 COMMENT '是否发货',
  PRIMARY KEY (`shoppingcart_id`) USING BTREE,
  INDEX `sc_userId`(`user_id` ASC) USING BTREE,
  INDEX `sc_goodsId`(`goods_id` ASC) USING BTREE,
  INDEX `sc_addressId`(`address_id` ASC) USING BTREE,
  CONSTRAINT `sc_addressId` FOREIGN KEY (`address_id`) REFERENCES `tb_address` (`address_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sc_goodsId` FOREIGN KEY (`goods_id`) REFERENCES `tb_information` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sc_userId` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shopping_cart
-- ----------------------------
INSERT INTO `tb_shopping_cart` VALUES (1, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (2, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (3, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (4, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (5, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (6, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (7, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (8, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (9, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (10, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (11, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (12, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (13, 8265209753713631232, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 5799000.00, 0, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (14, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (15, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (16, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (17, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (18, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (19, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (20, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (21, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (22, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (23, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (24, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (25, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 3189450.00, 1, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (26, 8265209753713631232, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 100, 5799000.00, 0, 1, 1);
INSERT INTO `tb_shopping_cart` VALUES (29, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 2, 6378.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (30, 1001, 1, 2, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (31, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (33, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (34, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (35, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (36, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (37, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (39, 1001, 7, 2, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 'Mix Fold 2', 9058.00, 10, 49819.00, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (40, 1001, 7, 2, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 'Mix Fold 2', 9058.00, 10, 49819.00, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (43, 1001, 1, 3, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (53, 1001, 1, 2, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (54, 1001, 1, 2, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (60, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (61, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (62, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 1);
INSERT INTO `tb_shopping_cart` VALUES (65, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (66, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (67, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (68, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 2, 5388.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (69, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 2, 5388.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (70, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 2, 5388.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (71, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 2, 5388.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (74, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 2, 5388.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (75, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (76, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (77, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (78, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (79, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (80, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (81, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (82, 1001, 2, 3, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 10, 26944.50, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (83, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (84, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (85, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (86, 1001, 2, 2, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (87, 1001, 6, 2, 'https://fms.res.meizu.com/dms/2021/09/22/652a6675-bb4c-451d-ba00-9f1dad100721.jpg', '18S Pro', 2599.00, 1, 1429.45, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (88, 1001, 2, 1, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (89, 1001, 2, 1, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (90, 1001, 2, 1, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (91, 1001, 2, 1, 'https://wwwstatic.vivo.com.cn/vivoportal/files/image/brand/20220720/6ca107944f04bd90796d3cd7bdc7ca9c.png', 'IQOO 10', 4899.00, 1, 2694.45, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (92, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (93, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (94, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (95, 1001, 1, 3, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (96, 1001, 7, 1, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 'Mix Fold 2', 9058.00, 1, 4981.90, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (97, 1001, 7, 1, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 'Mix Fold 2', 9058.00, 1, 4981.90, 1, 1, 0);
INSERT INTO `tb_shopping_cart` VALUES (98, 1001, 7, 2, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 'Mix Fold 2', 9058.00, 1, 4981.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (99, 1001, 7, 2, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 'Mix Fold 2', 9058.00, 1, 4981.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (100, 1001, 7, 2, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 'Mix Fold 2', 9058.00, 1, 4981.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (101, 1001, 7, 2, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 'Mix Fold 2', 9058.00, 1, 4981.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (102, 1001, 7, 2, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 'Mix Fold 2', 9058.00, 1, 4981.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (103, 1001, 7, 2, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 'Mix Fold 2', 9058.00, 1, 4981.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (105, 1001, 7, 2, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 'Mix Fold 2', 9058.00, 1, 4981.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (106, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (107, 1001, 7, 1, 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 'Mix Fold 2', 9058.00, 1, 4981.90, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (108, 1001, 1, 3, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (110, 8269452192292921344, 1, 32, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 5799.00, 0, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (111, 8269452192292921344, 1, 32, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 5799.00, 0, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (112, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (113, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 1, 3189.45, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (114, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 3, 9568.35, 1, 0, 0);
INSERT INTO `tb_shopping_cart` VALUES (115, 1001, 1, 1, 'https://images.samsung.com/is/image/samsung/assets/cn/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img_l.jpg?$ORIGIN_JPG$', 'Galaxy S22', 5799.00, 3, 9568.35, 1, 0, 0);

-- ----------------------------
-- Table structure for tb_slideshow
-- ----------------------------
DROP TABLE IF EXISTS `tb_slideshow`;
CREATE TABLE `tb_slideshow`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '轮播图id',
  `slideshow_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '轮播图名称',
  `slideshow_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '轮播图地址',
  `slideshow_status` int NOT NULL COMMENT '轮播图状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_slideshow
-- ----------------------------
INSERT INTO `tb_slideshow` VALUES (1, '初心会员', 'static\\img\\home_page\\cart-VIP.png', 1);
INSERT INTO `tb_slideshow` VALUES (2, 'iPhone 14 热卖中', 'https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/iphone-card-40-iphone14pro-202209?wid=340&hei=264&fmt=p-jpg&qlt=95&.v=1663611329492', 1);
INSERT INTO `tb_slideshow` VALUES (3, 'Mix Fold 2', 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 1);
INSERT INTO `tb_slideshow` VALUES (5, '小敏', 'https://consumer.huawei.com/content/dam/huawei-cbg-site/cn/mkt/pdp/phones/mate50/img/kv/kv@2x.webp', 0);
INSERT INTO `tb_slideshow` VALUES (6, '初心会员', 'static\\img\\home_page\\cart-VIP.png', 0);
INSERT INTO `tb_slideshow` VALUES (7, 'iPhone 14 热卖中', 'https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/iphone-card-40-iphone14pro-202209?wid=340&hei=264&fmt=p-jpg&qlt=95&.v=1663611329492', 1);
INSERT INTO `tb_slideshow` VALUES (8, 'Mix Fold 2', 'https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomimaxfold27xrd4s/1736.jpg?x-fds-process=image/resize,q_100,f_webp', 1);
INSERT INTO `tb_slideshow` VALUES (9, 'Mate 50', 'https://consumer.huawei.com/content/dam/huawei-cbg-site/cn/mkt/pdp/phones/mate50/img/kv/kv@2x.webp', 1);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `net_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '小三' COMMENT '网名',
  `user_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT 'https://pic3.zhimg.com/80/v2-e365bc594ff120bfb3f0ed73c58d21a6_720w.webp',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户邮箱',
  `created_date` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8269460511841705984 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1001, '解你忧', '小敏', 'https://pic3.zhimg.com/80/v2-e365bc594ff120bfb3f0ed73c58d21a6_720w.webp', '8e9729fae164d0301fc9a4c777dbd725', '1071588649@qq.com', '2022-09-19 20:55:12');
INSERT INTO `tb_user` VALUES (1002, '岳艳', '小乖乖', 'https://pic3.zhimg.com/80/v2-e365bc594ff120bfb3f0ed73c58d21a6_720w.webp', '5b0d6b536d2969bcf8cdcc1ab30d1d2b', '1793350224@qq.com', '2022-10-02 21:25:56');
INSERT INTO `tb_user` VALUES (8261606279743553536, 'jieniyou', '解你忧', 'https://pic3.zhimg.com/80/v2-e365bc594ff120bfb3f0ed73c58d21a6_720w.webp', 'b206e95a4384298962649e58dc7b39d4', '1799482162@qq.com', '2022-09-10 21:25:41');
INSERT INTO `tb_user` VALUES (8264166990365188096, '岳震', '岳岳', 'https://pic2.zhimg.com/80/v2-7f0b6ba0d2e48d54ab3e6a1bdfbedeb9_720w.webp', 'e10adc3949ba59abbe56e057f20f883e', '1904826914@qq.com', '2022-10-02 21:26:01');
INSERT INTO `tb_user` VALUES (8265209753713631232, '蔡林权', '小蔡', 'https://ts1.cn.mm.bing.net/th?id=OIP-C.x09r5tGxTyGiAchyk-KCjQAAAA&w=204&h=204&c=8&rs=1&qlt=90&o=6&pid=3.1&rm=2', 'e10adc3949ba59abbe56e057f20f883e', '3086097995@qq.com', '2022-10-14 10:14:17');
INSERT INTO `tb_user` VALUES (8265209753713631233, '李俊松', '俊松', 'https://picx.zhimg.com/v2-e0f370816741cec1ed707a8eaa93346b_1440w.jpg?source=172ae18b', 'e10adc3949ba59abbe56e057f20f883e', 'qq@qq.com', '2022-10-06 12:19:57');
INSERT INTO `tb_user` VALUES (8265209753713631234, '郑欣', '大猩猩', 'https://pic2.zhimg.com/80/v2-f63fd0eacecac8540754d941b66be669_720w.webp', 'e10adc3949ba59abbe56e057f20f883e', 'qq@qq.com', '2022-10-06 12:19:59');
INSERT INTO `tb_user` VALUES (8265209753713631235, '黄浩琦', '黄浩琦', 'https://pic2.zhimg.com/80/v2-617d1c7e0ce9014a9bcc13eb18e52889_720w.webp', 'e10adc3949ba59abbe56e057f20f883e', 'qq@qq.com', '2022-10-06 12:20:43');
INSERT INTO `tb_user` VALUES (8267005124588404736, '小艳子', '艳子', 'https://pic3.zhimg.com/80/v2-e365bc594ff120bfb3f0ed73c58d21a6_720w.webp', '8e9729fae164d0301fc9a4c777dbd725', '1793350224@qq.com', '2022-10-08 16:30:28');
INSERT INTO `tb_user` VALUES (8268774146923102208, 'admin', '', 'https://pic3.zhimg.com/80/v2-e365bc594ff120bfb3f0ed73c58d21a6_720w.webp', '202cb962ac59075b964b07152d234b70', 'sclz200267@qq.com', '2022-10-13 13:39:56');
INSERT INTO `tb_user` VALUES (8269452192292921344, '123321', '解你忧', 'https://pic3.zhimg.com/80/v2-e365bc594ff120bfb3f0ed73c58d21a6_720w.webp', '8e9729fae164d0301fc9a4c777dbd725', '1799482162@qq.com', '2022-10-15 10:34:14');
INSERT INTO `tb_user` VALUES (8269457383444570112, '345', '解你忧', 'https://pic3.zhimg.com/80/v2-e365bc594ff120bfb3f0ed73c58d21a6_720w.webp', 'b206e95a4384298962649e58dc7b39d4', '1799482162@qq.com', '2022-10-15 10:54:52');
INSERT INTO `tb_user` VALUES (8269460511841705984, '111', '解你忧', 'https://pic3.zhimg.com/80/v2-e365bc594ff120bfb3f0ed73c58d21a6_720w.webp', 'b206e95a4384298962649e58dc7b39d4', '1799482162@qq.com', '2022-10-15 11:07:18');

-- ----------------------------
-- Table structure for tb_wallet
-- ----------------------------
DROP TABLE IF EXISTS `tb_wallet`;
CREATE TABLE `tb_wallet`  (
  `wallet_id` bigint NOT NULL COMMENT '钱包id',
  `balance` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '余额',
  PRIMARY KEY (`wallet_id`) USING BTREE,
  CONSTRAINT `user_wallet` FOREIGN KEY (`wallet_id`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_wallet
-- ----------------------------
INSERT INTO `tb_wallet` VALUES (1001, 999990405738.95);
INSERT INTO `tb_wallet` VALUES (1002, 707150.50);
INSERT INTO `tb_wallet` VALUES (8261606279743553536, 10000.00);
INSERT INTO `tb_wallet` VALUES (8264166990365188096, 1000.00);
INSERT INTO `tb_wallet` VALUES (8265209753713631233, 10000.00);
INSERT INTO `tb_wallet` VALUES (8265209753713631234, 10000.00);
INSERT INTO `tb_wallet` VALUES (8267005124588404736, 100000.00);
INSERT INTO `tb_wallet` VALUES (8268774146923102208, 10000.00);

SET FOREIGN_KEY_CHECKS = 1;
