/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : digital_culture_heritage

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 02/11/2023 10:32:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity_promotion_apply
-- ----------------------------
DROP TABLE IF EXISTS `activity_promotion_apply`;
CREATE TABLE `activity_promotion_apply`  (
  `userId` int(0) NOT NULL COMMENT '用户id',
  `activityName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '活动名',
  `activityArea` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '活动地点',
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id，自增主键',
  `activityTime` datetime(0) NULL DEFAULT NULL COMMENT '活动时间',
  `promotionalWebsite` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '活动宣传网址',
  `activityIntroduction` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '活动介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity_promotion_apply
-- ----------------------------
INSERT INTO `activity_promotion_apply` VALUES (1, '师大之星', '励德楼', 1, '2023-11-11 08:00:00', 'http://www.hunnu.edu.cn', '非常好');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentId` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `cultureId` int(0) UNSIGNED NOT NULL COMMENT '讨论的技艺类型',
  `releaseTime` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论时间',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论摘要',
  `picture` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论的图片',
  `more` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '“查看更多”的url',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '论坛的标题',
  PRIMARY KEY (`commentId`) USING BTREE,
  INDEX `cultureId`(`cultureId`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`cultureId`) REFERENCES `culture` (`cultureId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 2, '2023年12月17日', '邵阳蓝印花布又称豆浆布，是一种用石灰豆浆防染花靛蓝色的双色布。深重的蓝，纯净的白，质朴的色彩，古拙的纹样，显现出浓烈的乡土气息。邵阳蓝印花布源自远古时代苗族、瑶族人的“阑干斑布”和“蜡缬”。', 'https://pic1.zhimg.com/v2-21f4ca97ec88cb23b77119eb2c117e5d_r.jpg', 'https://sy.rednet.cn/content/2019/12/17/6381470.html', '蓝印花布技艺');
INSERT INTO `comment` VALUES (2, 5, '2023年10月23日', '苗族银饰锻制技艺历史悠久，先后经历了从原始装饰品到岩石贝壳装饰品、从植物花卉饰品到金银饰品的演进历程，传承延续下来，才有了模式和形态基本定型的银饰，其品种式样至今还在不断地翻新，由此形成的饰品链条成为苗族社会演进的象征之一。', 'https://www.cdstm.cn/gallery/media/mkjx/shijieyichan/201806/W020180627569165446292.jpg', 'https://www.ihchina.cn/art/detail/id/9874.html', '苗族银饰锻制技艺');
INSERT INTO `comment` VALUES (3, 10, '2023年11月08日', '醴陵釉下五彩瓷烧制技艺，从原料制作到产品烧成要经过近百道工序，全部靠手工完成，突破了釉下单彩的传统工艺，调配出丰富多彩的陶瓷绘画色料，讲究淡雅用色的表现手法，采用双勾分水的独特技法，烧制成的瓷器釉面晶莹润泽、釉胎白泛青，近乎写真效果。', 'http://www.zhongguociwang.com/upload/2017-09/17091714359793.jpg', 'https://baijiahao.baidu.com/s?id=1669438379411300840', '醴陵釉下五彩瓷烧制技艺');
INSERT INTO `comment` VALUES (4, 8, '2023年9月15日', '岳州扇是中国三大名扇之一，始于明末清初。岳州扇以湖南本地产的优质竹子为扇骨，牛角为钉，宣纸为面，就制作技艺来说，分扇骨和扇面制作两大程序，包括锯筒、劈片、边骨推青、小骨推青、镶边骨、取边、打磨、钻眼等72道工序。', 'http://www.yyx.gov.cn/uploadfiles/202012/20201223151708593.png', 'http://www.xinhuanet.com/culture/20220701/7ac919e400a845bca7b6ae1ed12691cb/c.html', '制扇技艺（岳州扇制作技艺）');

-- ----------------------------
-- Table structure for culture
-- ----------------------------
DROP TABLE IF EXISTS `culture`;
CREATE TABLE `culture`  (
  `cultureId` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '非物质文化遗产名称',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '非物质文化遗产类别',
  `kind` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '非物质文化遗产类型',
  `announcementTime` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公布时间',
  `productNumber` int(0) NOT NULL COMMENT '国家非遗项目序号',
  `declaringUnit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '非遗申报单位',
  `protectionUnit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '非遗保护单位',
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '介绍',
  `model` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '3d模型url',
  `topic` int(0) NULL DEFAULT 0 COMMENT '是否是热点文化，1表示“是”；0表示“否”',
  PRIMARY KEY (`cultureId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of culture
-- ----------------------------
INSERT INTO `culture` VALUES (1, '土家族织锦技艺', '传统技艺', '新增项目', '2006', 368, '湖南省湘西土家族苗族自治州', '湘西土家族苗族自治州非物质文化遗产保护中心', '湘西酉水流域土家族织锦技艺主要分布于永顺、龙山、保靖、古丈四县的土家族聚居区。土家锦用绵线织成，俗称“打花”，主要有打花铺盖（土家语西兰卡普）和花带两大品种。其中西兰卡普最具代表性和典型性，它采用“通经断纬”的挖花技术，分为“对斜”平纹素色系列和“上下斜”斜纹彩色系列两大流派。西兰卡普使用古老的纯木质腰式斜织机织造，其技艺流程主要由纺捻线、染色、倒线、牵线、装筘、滚线、捡综、翻篙、捡花、捆杆上机、织布、挑织等12道工序组成，另以“反织法”挑织成图案花纹。花带是土家锦中普及面更广的品种，它采用“通经通纬”的古老“经花”手法，几乎不需专用工具即可在织造者两膝间完成。\r\n　　湘西土家族织锦技艺历史悠久，自成形以来已有一千五百多年的历史，体现了中国少数民族织锦技艺体系的基本特征。\r\n　　土家锦的四百多种传统图案花纹是其民族文化心理和不同时代文化积淀的独特表现方式，充分展示了土家人的创造力，对中华民族多元文化的形成与发展有积极的见证意义。\r\n　　湘西酉水流域土家族地区是土家锦手工技艺的原生地和最后一块热土，也是全国土家族中至今仍保留民间织造风尚的惟一区域。然而，社会的变革、经济结构和文化意识的变化，正使土家族织锦技艺逐步失去赖以生存的土壤和环境，陷入全面濒危的境地，亟待采取强有力的措施予以保护。', NULL, 1);
INSERT INTO `culture` VALUES (2, '蓝印花布印染技艺', '传统技艺', '扩展项目', '2008', 374, '湖南省凤凰县', '凤凰县非物质文化遗产保护中心', '蓝印花布原称“浇花布”，宋代称为“药斑布”，是我国民间长期流传的一种纺织印染品。\r\n　　湖南省是我国蓝印花布的主要产区，凤凰县和邵阳县的蓝印花布印染在各方面都十分突出。\r\n　　凤凰县沱江镇的蓝印花布印染技艺历史悠久，源远流长。西汉时期，蓝印花布即已出现。明代宋应星的《天工开物》有蓝草可以提取靛蓝的记载，同时详尽记述了当时的制蓝方法。蓝印花布印染技艺分纯蓝花布印染和彩蓝花布印染两大类：纯蓝花布布面素净，没有花纹图案，一般用以制作衣服和头帕；彩蓝花布有复杂的花纹图案，一般用以制作被面、垫单、帐檐、围裙、围腰、门帘、桌布、围布等。印染前需要经过裱纸版、描稿、刻版、上油、调料、刮浆、入染等工艺的处理，入染之后还要经过晾晒、淌洗、卷布、碾布（又叫“踩布”）的工艺流程。沱江镇著名艺人刘大炮在单面蓝印花布的基础上创造了一种双面蓝印花布，其印染手段较为复杂，具有十分珍贵的工艺价值。沱江镇过去从事印染行业的有上百家，目前只剩下十余家小型家庭作坊，而且印染匠人大多年事已高，在此形势下，凤凰蓝印花布印染技艺面临失传的危险。\r\n　　邵阳蓝印花布约始于唐代贞观年间，至今已有一千四百多年的历史。据《邵阳县志》记载，当时邵阳人在苗族蜡染工艺的基础上创造了以豆浆、石灰替代蜡的印染技法。明清两代，由于水陆交通便利，邵阳成为中南地区最大的蓝印花布生产基地。邵阳蓝印花布纹样古朴，点线细密，注重大面积对比和细部刻画，风格清新淳朴。其纹样大多取材于民间传说和传统吉祥图案，表现出对美好生活的向往和追求。\r\n　　随着时代的发展和社会生活方式的变迁，凤凰、邵阳蓝印花布印染技艺受到机械印染的冲击，日益衰落，已经陷入濒危境地，亟待抢救保护。', NULL, 0);
INSERT INTO `culture` VALUES (3, '蓝印花布印染技艺', '传统技艺', '扩展项目', '2008', 374, '湖南省邵阳县', '邵阳县文化馆', '蓝印花布原称“浇花布”，宋代称为“药斑布”，是我国民间长期流传的一种纺织印染品。\r\n　　湖南省是我国蓝印花布的主要产区，凤凰县和邵阳县的蓝印花布印染在各方面都十分突出。\r\n　　凤凰县沱江镇的蓝印花布印染技艺历史悠久，源远流长。西汉时期，蓝印花布即已出现。明代宋应星的《天工开物》有蓝草可以提取靛蓝的记载，同时详尽记述了当时的制蓝方法。蓝印花布印染技艺分纯蓝花布印染和彩蓝花布印染两大类：纯蓝花布布面素净，没有花纹图案，一般用以制作衣服和头帕；彩蓝花布有复杂的花纹图案，一般用以制作被面、垫单、帐檐、围裙、围腰、门帘、桌布、围布等。印染前需要经过裱纸版、描稿、刻版、上油、调料、刮浆、入染等工艺的处理，入染之后还要经过晾晒、淌洗、卷布、碾布（又叫“踩布”）的工艺流程。沱江镇著名艺人刘大炮在单面蓝印花布的基础上创造了一种双面蓝印花布，其印染手段较为复杂，具有十分珍贵的工艺价值。\r\n　　沱江镇过去从事印染行业的有上百家，目前只剩下十余家小型家庭作坊，而且印染匠人大多年事已高，在此形势下，凤凰蓝印花布印染技艺面临失传的危险。\r\n　　邵阳蓝印花布约始于唐代贞观年间，至今已有一千四百多年的历史。据《邵阳县志》记载，当时邵阳人在苗族蜡染工艺的基础上创造了以豆浆、石灰替代蜡的印染技法。明清两代，由于水陆交通便利，邵阳成为中南地区最大的蓝印花布生产基地。邵阳蓝印花布纹样古朴，点线细密，注重大面积对比和细部刻画，风格清新淳朴。其纹样大多取材于民间传说和传统吉祥图案，表现出对美好生活的向往和追求。\r\n　　随着时代的发展和社会生活方式的变迁，凤凰、邵阳蓝印花布印染技艺受到机械印染的冲击，日益衰落，已经陷入濒危境地，亟待抢救保护。', NULL, 0);
INSERT INTO `culture` VALUES (4, '侗族木构建筑营造技艺（通道侗族木构建筑营造技艺）', '传统技艺', '扩展项目', '2021', 380, '湖南省怀化市通道侗族自治县', '通道侗族自治县非物质文化遗产保护中心', '\r\n\r\n\r\n侗族木构建筑营造技艺最早可追溯至原始氏族社会早期甚至是更早的巢居时期，那时的黔台语族的先民，就已创造了这种以“竹木结构”“卯榫结构”“雕梁画栋”为特色的“建筑文化”，侗族人民将其完整的传承了下来。\r\n      魏唐时期，侗族就已经有了干栏式建筑，至今已有将近一千多年的历史。《魏书·僚人》就有“依树积木，以居其上，名曰干栏”的记载，这足以证明侗族木构建筑营造技艺的悠久历史。在这一时期，侗族本构建筑营造技艺逐步的发展完善，最终形成了当代的木构建筑营造技艺。\r\n      侗族木建筑不仅造型美观，而且工艺堪称一绝，整座建筑凿榫打眼，穿梁接拱，立柱连枋，不用一颗铁钉，全用榫卯连接，结构牢固，铆接缜密。围绕木建筑表现出的文化内涵十分丰富，有极高的艺术价值。\r\n鼓楼雄踞于侗寨之中，立地顶天，是侗家人的精神象征。风雨桥横卧江上，是侗族人民的“福桥”“生命之桥”，楼、桥绘制的各种图案，雕梁画栋，寄托了侗族人民的祈望风调雨顺，五谷丰登的美好愿望和美学追求。\r\n\r\n\r\n', NULL, 0);
INSERT INTO `culture` VALUES (5, '苗族银饰锻制技艺', '传统技艺', '新增项目', '2006', 390, '湖南省凤凰县', '凤凰县传承民族工艺有限责任公司', '银饰是苗族最喜爱的传统饰物，主要用于妇女的装饰，品种多样，分为头饰、面饰、颈饰、肩饰、胸饰、腰饰、臂饰、脚饰、手饰等，彼此配合，体现出完美的整体装饰效果。\r\n　　银凤冠和银花帽是头饰中的主要饰品，也是整套银饰系列之首，素有龙头凤尾之美称，其制作较为复杂，使用的小件饰品少则一百五十余件，多则达两百余件，价值昂贵。苗族银饰精致美观，以贵州省雷山县和湖南省凤凰县的制品为代表，其中雷山县的银匠主要集中在西江镇的控拜、麻料、乌高。\r\n　　银饰锻制是苗族民间独有的技艺，所有饰件都通过手工制作而成。银饰的式样和构造经过了匠师的精心设计，由绘图到雕刻和制作有30道工序，包含铸炼、捶打、焊接、编结、洗涤等环节，工艺水平极高。\r\n　　苗族银饰制作技艺历史悠久，先后经历了从原始装饰品到岩石贝壳装饰品、从植物花卉饰品到金银饰品的演进历程，传承延续下来，才有了模式和形态基本定型的银饰，其品种式样至今还在不断地翻新，由此形成的饰品链条成为苗族社会演进的象征之一。\r\n　　苗族银饰具有丰富多彩的文化内涵，从品种、图案设计、花纹构建到制作组装都有很高的文化品位。在对外交往中，苗族人民把银饰作为礼品赠送友人，和藏族的哈达、汉族的珠宝一样珍贵。\r\n　　苗族银饰的创制技艺充分体现了苗族人民聪明能干、智慧机巧、善良友好的民族性格。银饰洁白可爱、纯净无瑕、质地坚硬，正是苗族精神品质的体现。\r\n　　苗族银饰长久以来都是在苗族地区流传，改革开放后，其开发前景看好。但是，银饰锻打技艺一般是在家庭内部承传，无法择优而授，原有艺人多已年老，真正能继承银饰锻造这一精湛工艺的并不多，所以这门特色技艺的发展前景不容乐观，有必要加强保护工作。', NULL, 0);
INSERT INTO `culture` VALUES (6, '竹纸制作技艺（蔡伦古法造纸技艺）', '传统技艺', '扩展项目', '2014', 421, '湖南省耒阳市', '耒阳市蔡伦纪念馆', '公元105年，蔡伦利用树皮、麻头、旧渔网造出了世界上第一张植物纤维纸，人类的文明史从此翻开了新的一页。\r\n“蔡伦古法造纸”作为中国古代四大发明之一，其技艺发端于东汉永元间（89-105），极大地促进了世界文化、科技的交流，推动了人类文明和社会的发展。而耒阳古法造纸技艺源于蔡伦亲授，是对蔡伦古法造纸技艺完整系统的继承，距今已有1900余年的历史，堪称蔡伦古法造纸技艺的“活化石”。千百年来，耒阳生产的手工造纸以其产品的多样性服务于社会诸多领域，曾经为耒阳、湖湘乃至中华文明和社会发展作出了巨大贡献。', NULL, 1);
INSERT INTO `culture` VALUES (7, '竹纸制作技艺（滩头手工抄纸技艺） ', '传统技艺', '扩展项目', '2014', 421, '湖南省隆回县 ', '隆回县非物质文化遗产保护中心', '无', NULL, 0);
INSERT INTO `culture` VALUES (8, '制扇技艺（岳州扇制作技艺）', '传统技艺', '扩展项目', '2021', 431, '湖南省岳阳市岳阳县', '岳阳县文化馆', '无', NULL, 0);
INSERT INTO `culture` VALUES (9, '浏阳花炮制作技艺', '传统技艺', '新增项目', '2006', 436, '湖南省浏阳市', '浏阳市烟花爆竹总会', '浏阳花炮源远流长。1935年出版的《中国实业志》记载：“湘省爆竹之制造，始于唐，盛于宋，发源于浏阳也。”浏阳花炮一直尊李畋为始祖。清代康熙年间，浏阳花炮的生产已具相当规模。至光绪年间，它已销往香港、澳门、南洋诸国，成为名牌产品。中华人民共和国成立后，浏阳花炮由历史上的外销二十多个国家和地区发展到外销五大洲一百多个国家和地区，内销则达于全国32个省市自治区，其品种也由三十多个发展到现在的13大类三千多个。1995年浏阳市被国家授予“中国烟花之乡”的荣誉称号；2002年成立国际烟花协会（IFA），总部常设浏阳；2003年国家质量监督检验检疫总局对浏阳花炮实施原产地域产品保护；2004年国家工商总局注册“浏阳花炮”驰名商标。\r\n　　浏阳花炮与中国古老的民俗结下了不解之缘。传统节日中，人们无不放鞭炮烟花以志喜庆。举行各种祭祀庆典时，也须燃放花炮。\r\n　　浏阳花炮生产原是传统技艺，全靠手工制作，有12道流程、72道工序。随着现代科学技术的发展，从业人员已研制成功安全可靠无公害的无烟烟花、冷光烟花、日观烟花、室内和舞台烟花等高科技新产品，达到世界领先水平。花炮燃放也可由传统的手工点火改为遥控点火，燃放程序全部由电脑编排操控。\r\n　　浏阳现已成为我国最大的花炮产销地。2004年，花炮产业实现产值32亿元，创税收6亿元。在近30万浏阳花炮从业人员中，有90%来自农村，吸收了全市70%以上的农村剩余劳动力。目前浏阳正在筹建花炮博物馆，建成后将成为中国花炮收藏、研究、展示和交流的中心。', NULL, 1);
INSERT INTO `culture` VALUES (10, '醴陵釉下五彩瓷烧制技艺', '传统技艺', '新增项目', '2008', 878, '湖南省醴陵市', '醴陵市文化馆', '釉下五彩瓷是湖南醴陵独创的技艺，具有悠久的历史。在唐代，长沙附近的铜官窑已有釉下绿彩、褐彩的花鸟纹样。醴陵釉下五彩瓷从原料到成品要经过近一百道工序，全部靠手工完成。制瓷填料、釉料和颜料均选用本地优质原料制作而成。其彩绘图画采用自制釉下色料，运用双勾分水填色等技法将画面溶于釉下，使其平滑光亮，具有饱满的水分感。覆盖在纹饰上的釉经高温烧成后，形成玻璃质，更显得莹润光洁。釉下五彩瓷所用颜料以金属氧化物为着色剂，其熔剂中不含铅、镉等有毒物质，能耐酸碱。坯件成型后须经800℃素烧，以提高坯件的强度。坯件彩绘完毕，以喷釉覆盖其画面，而后以1350℃—1410℃高温烧制出成品，使五颜六色的画面从釉层中显现出来。其使用釉下氧化钴着色的工艺被后世青花瓷器广泛采用。\r\n　　近代以来，醴陵釉下五彩瓷器以其独特的工艺和优良的品质在国际国内屡屡获奖。1909年在“武汉劝业奖进会”上获得一等金质奖；1910年参加“南洋劝业会”获得一等金奖；1912年在“意大利都朗博览会”上获得最优奖；1915年在美国旧金山举行的“巴拿马太平洋万国博览会”上获得金牌奖。中华人民共和国成立后，醴陵釉下五彩瓷多次获得金奖和银奖，被选为中南海、人民大会堂等重要场所的专用瓷器，还多次作为国礼赠送给外国元首。醴陵釉下五彩瓷烧制技艺是我国瓷器的一大发明，对世界陶瓷装饰方法产生了很大影响，具有较高的科技和历史文化价值。', NULL, 0);
INSERT INTO `culture` VALUES (11, '侗锦织造技艺', '传统技艺', '新增项目', '2008', 887, '湖南省通道侗族自治县', '通道侗族自治县非物质文化遗产保护中心', '侗锦织造技艺主要分布在湖南省通道侗族自治县，其历史可追溯到距今两千多年的春秋战国时代。两汉至唐宋时期，侗族先民的纺织和印染工艺已形成自己独特的风格。明清时期，随着侗民族的形成及其民族传统文化的日趋成熟，侗锦织造技艺也得到极大的发展。\r\n　　侗锦分素锦、彩锦两种，都以手工操作织成，需要经过轧棉、纺纱、染纱、绞纱、绞经、排经、织锦等工序。侗族妇女通过织锦展示她们的聪明才智和精湛的手工技艺。侗锦图案演绎了侗族的历史和文化，反映了侗族人民的图腾崇拜、宗教信仰以及避凶趋吉、消灾纳福、与自然和谐共存等民族文化心理。富有民族特色的图案，丰富而深刻的文化内涵，亮丽和谐的色彩，高雅凝重的品质，使侗锦成为我国著名的织锦之一，具有独特的文化艺术价值、社会历史价值和科学技术价值。\r\n　　进入21世纪以来，我国民族地区的社会经济有了突飞猛进的发展，少数民族传统与生活习俗受到工业文明的冲击，侗锦这一传统工艺的传承同样也受到影响。保护少数民族传统文化、保护侗锦这一优秀的民族传统工艺已刻不容缓。', NULL, 1);
INSERT INTO `culture` VALUES (12, '民族乐器制作技艺（坛下乡铜锣传统制作技艺）', '传统技艺', '扩展项目', '2021', 907, '湖南省衡阳市耒阳市', '耒阳市坛下冬元锣鼓厂', '无', NULL, 0);
INSERT INTO `culture` VALUES (13, '黑茶制作技艺（千两茶制作技艺）', '传统技艺', '新增项目', '2008', 935, '湖南省安化县', '安化县文化馆', '黑茶是茶类中唯一可以长期存放的品种，其生产全由手工操作。黑茶以质优取胜，制作标准严格，精益求精，要求选茶准、烘茶干、装茶满、踩茶紧，生产流程环环相扣，一丝不苟。我国黑茶以湖南省的安化千两茶、益阳茯砖茶和四川省的雅安南路边茶最为著名。这些黑茶都具有历史悠久、文化底蕴深厚、制作技艺科技含量高等特点。\r\n　　湖南省安化县素有“中国茶乡”之称。唐代中期，这里出产的“渠江薄片”茶被列为贡品。宋代熙宁年间，安化置县时，当地的茶已“甲于诸州市”。明代万历年间，安化黑茶被定为官茶，销往西北和国外，民间因而有黑茶“无安化字号不买”之说。清代道光元年（1821），当地茶商为便于运输，将黑茶踩捆成小圆栓形，每支定为100两；同治二年（1863）又增加为1000两，故有“安化千两茶”之名。安化千两茶的制作分黑毛茶制作和精深加工两个阶段，黑毛茶制作包括杀青、揉捻、渥堆、复揉、烘焙5道工序，精深加工工序则要复杂得多，包括筛分、拼配、软化、装篓、踩压、扎箍、锁口、冷却、干燥等一系列环节，经日晒夜露55天制作成黑茶成品。', NULL, 0);
INSERT INTO `culture` VALUES (14, '黑茶制作技艺（茯砖茶制作技艺）', '传统技艺', '新增项目', '2008', 935, '湖南省益阳市', '益阳茶厂有限公司', '黑茶是茶类中唯一可以长期存放的品种，其生产全由手工操作。黑茶以质优取胜，制作标准严格，精益求精，要求选茶准、烘茶干、装茶满、踩茶紧，生产流程环环相扣，一丝不苟。我国黑茶以湖南省的安化千两茶、益阳茯砖茶和四川省的雅安南路边茶最为著名。这些黑茶都具有历史悠久、文化底蕴深厚、制作技艺科技含量高等特点。\r\n　　茯砖茶产于湖南省益阳市，这是黑茶类中唯一具有发花工艺从而能产生有益菌的一个茶种，系以优质黑毛茶为原料，经渥堆、发酵、筑制成型和发花等环节制作而成。数百年来，在我国西北地区，茯砖茶与奶、肉并列，以其不可替代的独特功效成为各少数民族的生活必需品，被誉为中国古丝绸之路的“神秘之茶”和西北各少数民族的“生命之茶”。茯砖茶中独含的两种活性物质——茯茶素A和茯茶素B，具有促进人体新陈代谢，显著降低脂肪、血脂、胆固醇、甘油酯、血糖、血压等功效。茯砖茶集医药价值、收藏价值于一体，对人们的物质和文化生活产生了深刻的影响。', NULL, 0);
INSERT INTO `culture` VALUES (15, '长沙窑铜官陶瓷烧制技艺', '传统技艺', '新增项目', '2011', 1171, '湖南省长沙市望城区', '长沙市望城区铜官陶瓷行业协会', '古镇铜官位于湖南省长沙市望城区湘江东岸，是全国五大陶都之一。铜官陶瓷产业历史悠久，文化内涵丰富，陶瓷技艺独具特色。在殷商之前，舜帝就带领先民在湘江一带开始了制陶之业。至唐代铜官陶瓷发展迅速，陶瓷技艺逐渐成熟。铜官是世界陶瓷釉下多彩的发祥地，首创陶瓷釉下多彩新工艺。\r\n　　长沙窑铜官陶瓷技艺，反映了先民们的创新精神，其制作堪称绝技。主要有拉坯成型、捏坯成型、雕塑成型、贴花、画花、制釉、制泥、烧成等多项技艺。\r\n　　长沙窑铜官陶瓷技艺是我国著名的民间工艺，在铜官有着深厚的群众基础，沿湘江两岸，十里陶城绵延不绝，焰火不止。长沙窑铜官陶瓷技艺对唐代以后的陶瓷生产产生了巨大影响，传承至今。在铜官镇区，现在已形成了一个有四千余人从业的陶瓷生产区，其产品畅销全国。', NULL, 0);
INSERT INTO `culture` VALUES (16, '土家族吊脚楼营造技艺', '传统技艺', '新增项目', '2011', 1191, '湖南省永顺县', '永顺县非物质文化遗产保护中心', '湖南省永顺县土家族吊脚楼（又称“转角楼”）建造技艺是土家族人民在长期社会生活中创造的具有民族特色的传统手工技艺，被专家学者称为古建筑的“活化石”。\r\n　　转角楼的建造，源于春秋战国，兴盛于唐宋，彭氏政权统治湘西后，转角楼开始全面发展。清雍正年间解除梁柱、盖瓦之禁，转角楼又广泛流布。新中国成立后，人民居住条件有较大发展，转角楼的建造技艺达到顶峰。但是，随着社会进程的加快，转角楼逐渐被现代建筑所取代，传承区域及传承人严重萎缩，目前，这一传统建筑仅分布在永顺县泽家、石堤、车坪、颗砂、芙蓉等少数乡镇，传承人减少且后继乏人，传承活动难以为继。\r\n　　转角楼的建造技艺工序很多，主要有：备料、加工、排扇、上梁。土家族转角楼多为木质结构，干栏式建筑，飞檐翘角，四面均有走廊，悬出的木质栏杆上雕有万字格、亚字格、四方格等象征吉祥如意的图案。悬柱有八棱形、六棱形、四方形，底部雕刻有绣球、金瓜等各种图案；窗棂刻有双凤朝阳、喜鹊嗓枝、狮子滚绣球以及牡丹、菊花等各种花草，古朴雅秀，美观实用，具有鲜明的个性和手工技艺的特色。\r\n　　转角楼的形式多种多样，主要有单吊式转角楼、双吊式转角楼、四合水式转角楼等，具有无坎不成楼、无瓜不成趣、不转不成楼等建筑特征。结构独特，形式活泼，是集建筑、绘画和雕刻等艺术为一体的珍贵的民间艺术结晶，也是中国建筑艺术史上的杰出代表。', NULL, 1);
INSERT INTO `culture` VALUES (17, '黄茶制作技艺（君山银针茶制作技艺）', '传统技艺', '新增项目', '2021', 1513, '湖南省岳阳市君山区', '岳阳市君山区文化馆', '无', NULL, 0);
INSERT INTO `culture` VALUES (18, '果脯蜜饯制作技艺（雕花蜜饯制作技艺）', '传统技艺', '新增项目', '2021', 1520, '湖南省怀化市靖州苗族侗族自治县', '靖州苗族侗族自治县博物馆（靖州苗族侗族自治县非物质文化遗产保护中心）', '无', NULL, 0);
INSERT INTO `culture` VALUES (19, '小吃制作技艺（火宫殿臭豆腐制作技艺）', '传统技艺', '新增项目', '2021', 1522, '湖南省长沙市', '长沙饮食集团长沙火宫殿有限公司', '无', NULL, 0);

-- ----------------------------
-- Table structure for offlineexperience
-- ----------------------------
DROP TABLE IF EXISTS `offlineexperience`;
CREATE TABLE `offlineexperience`  (
  `activityId` int(0) NOT NULL AUTO_INCREMENT COMMENT '所有文化的线下活动的编号',
  `cultureId` int(0) UNSIGNED NOT NULL COMMENT '活动对应的非遗文化编号，和culture关联',
  `contactId` int(0) NOT NULL COMMENT '联系人编号，和user关联',
  `activityName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '店铺名字/活动名称',
  `tradeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主办方/公司名称',
  `businessHours` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '店铺营业时间/活动举办时间',
  `venue` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '店铺/活动举办实际地点',
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '店铺/活动介绍',
  `activityPhoto` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动图片/宣传片的url',
  `praiseNumber` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '点赞数',
  `status` int(0) UNSIGNED NULL DEFAULT 2 COMMENT '当前活动/店铺的状态，1正常，2待审批，3已结束。默认待审批',
  `detail` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动详情网址url',
  PRIMARY KEY (`activityId`) USING BTREE,
  INDEX `cultureId`(`cultureId`) USING BTREE,
  INDEX `contactId`(`contactId`) USING BTREE,
  CONSTRAINT `offlineexperience_ibfk_1` FOREIGN KEY (`cultureId`) REFERENCES `culture` (`cultureId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `offlineexperience_ibfk_2` FOREIGN KEY (`contactId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of offlineexperience
-- ----------------------------
INSERT INTO `offlineexperience` VALUES (1, 2, 1, '体验古法蓝染制作', '染布公司', '8：00-17:00 ', '梅溪湖', '一块蓝染布，\r\n隐匿于扎染的千年时光，\r\n闻得见诗经的味道。\r\n蓝白两色创造了一个淳朴自然、\r\n千变万化的艺术世界。', 'https://img.alicdn.com/imgextra/i2/363098991/TB2ryYDX91I.eBjy0FjXXabfXXa_!!363098991.jpg', 2, 1, 'http://xhslink.com/mYuy4v');
INSERT INTO `offlineexperience` VALUES (2, 1, 1, '张家界-精美技艺土家锦和砂石画', '张家界旅游商品产业园', '周一至周五10:00-16:00', '张家界永定区沙堤街道旅游商品产业园', '土家织锦文化创意园和军声砂石画文创园', 'https://www.xilankapu.com/wp-content/uploads/2020/07/1594808389-6edd4c48c4ad65b-748x1024.jpg', 3, 2, 'https://www.xiaohongshu.com/explore/63ccefd2000000001b01687c');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `role` int(0) NOT NULL DEFAULT 3 COMMENT '用户角色，1表示系统管理员，2表示消费者，3是普通用户',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户的登录账号，唯一',
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户的姓名',
  `password` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户的登录密码',
  `workUnit` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的工作单位',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的电子邮箱',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的手机号码',
  `balance` int(0) NULL DEFAULT NULL COMMENT '消费者的余额',
  `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的头像url',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_user_u`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 3, '张三', '过往烟云', 'e10adc3949ba59abbe56e057f20f883e', '湖南师范大学', '123456765@qq.com', '13135475865', NULL, '');
INSERT INTO `user` VALUES (2, 2, '李四', '雨纷纷', '123456', '湘西染布有限公司', '9995555123@qq.com', '13587946534', 30, NULL);

SET FOREIGN_KEY_CHECKS = 1;
