/* *
 * 全局空间 Vcity
 * */
var Vcity = {};
var allCity = [{ name: '石家庄市', code: 'Shijiazhuang Shi', shortcode: 'SJW', id: '37' }, { name: '唐山市', code: 'Tangshan Shi', shortcode: 'TGS', id: '38' }, { name: '秦皇岛市', code: 'Qinhuangdao Shi', shortcode: 'SHP', id: '39' }, { name: '邯郸市', code: 'Handan Shi', shortcode: 'HDS', id: '40' }, { name: '邢台市', code: 'Xingtai Shi', shortcode: 'XTS', id: '41' }, { name: '保定市', code: 'Baoding Shi', shortcode: 'BDS', id: '42' }, { name: '张家口市', code: 'Zhangjiakou Shi ', shortcode: 'ZJK', id: '43' }, { name: '承德市', code: 'Chengde Shi', shortcode: 'CDS', id: '44' }, { name: '沧州市', code: 'Cangzhou Shi', shortcode: 'CGZ', id: '45' }, { name: '廊坊市', code: 'Langfang Shi', shortcode: 'LFS', id: '46' }, { name: '衡水市', code: 'Hengshui Shi ', shortcode: 'HGS', id: '47' }, { name: '太原市', code: 'Taiyuan Shi', shortcode: 'TYN', id: '48' }, { name: '大同市', code: 'Datong Shi ', shortcode: 'DTG', id: '49' }, { name: '阳泉市', code: 'Yangquan Shi', shortcode: 'YQS', id: '50' }, { name: '长治市', code: 'Changzhi Shi', shortcode: 'CZS', id: '51' }, { name: '晋城市', code: 'Jincheng Shi ', shortcode: 'JCG', id: '52' }, { name: '朔州市', code: 'Shuozhou Shi ', shortcode: 'SZJ', id: '53' }, { name: '晋中市', code: 'Jinzhong Shi', shortcode: '2', id: '54' }, { name: '运城市', code: 'Yuncheng Shi', shortcode: '2', id: '55' }, { name: '忻州市', code: 'Xinzhou Shi', shortcode: '2', id: '56' }, { name: '临汾市', code: 'Linfen Shi', shortcode: '2', id: '57' }, { name: '吕梁市', code: 'Lvliang Shi', shortcode: '2', id: '58' }, { name: '呼和浩特市', code: 'Hohhot Shi', shortcode: 'Hhht', id: '59' }, { name: '包头市', code: 'Baotou Shi ', shortcode: 'BTS', id: '60' }, { name: '乌海市', code: 'Wuhai Shi', shortcode: 'WHM', id: '61' }, { name: '赤峰市', code: 'Chifeng (Ulanhad)Shi', shortcode: 'CFS', id: '62' }, { name: '通辽市', code: 'Tongliao Shi', shortcode: '2', id: '63' }, { name: '鄂尔多斯市', code: 'Eerduosi Shi', shortcode: '2', id: '64' }, { name: '呼伦贝尔市', code: 'Hulunbeier Shi ', shortcode: '2', id: '65' }, { name: '巴彦淖尔市', code: 'Bayannaoer Shi', shortcode: '2', id: '66' }, { name: '乌兰察布市', code: 'Wulanchabu Shi', shortcode: '2', id: '67' }, { name: '兴安盟', code: 'Hinggan Meng', shortcode: 'HIN', id: '68' }, { name: '锡林郭勒盟', code: 'Xilin Gol Meng', shortcode: 'XGO', id: '69' }, { name: '阿拉善盟', code: 'Alxa Meng', shortcode: 'ALM', id: '70' }, { name: '沈阳市', code: 'Shenyang Shi', shortcode: 'SHE', id: '71' }, { name: '大连市', code: 'Dalian Shi', shortcode: 'DLC', id: '72' }, { name: '鞍山市', code: 'AnShan Shi', shortcode: 'ASN', id: '73' }, { name: '抚顺市', code: 'Fushun Shi', shortcode: 'FSN', id: '74' }, { name: '本溪市', code: 'Benxi Shi', shortcode: 'BXS', id: '75' }, { name: '丹东市', code: 'Dandong Shi', shortcode: 'DDG', id: '76' }, { name: '锦州市', code: 'Jinzhou Shi', shortcode: 'JNZ', id: '77' }, { name: '营口市', code: 'Yingkou Shi', shortcode: 'YIK', id: '78' }, { name: '阜新市', code: 'Fuxin Shi', shortcode: 'FXS', id: '79' }, { name: '辽阳市', code: 'Liaoyang Shi', shortcode: 'LYL', id: '80' }, { name: '盘锦市', code: 'Panjin Shi', shortcode: 'PJS', id: '81' }, { name: '铁岭市', code: 'Tieling Shi', shortcode: 'TLS', id: '82' }, { name: '朝阳市', code: 'Chaoyang Shi', shortcode: 'CYS', id: '83' }, { name: '葫芦岛市', code: 'Huludao Shi', shortcode: 'HLD', id: '84' }, { name: '长春市', code: 'Changchun Shi ', shortcode: 'CGQ', id: '85' }, { name: '吉林市', code: 'Jilin Shi ', shortcode: 'JLS', id: '86' }, { name: '四平市', code: 'Siping Shi', shortcode: 'SPS', id: '87' }, { name: '辽源市', code: 'Liaoyuan Shi', shortcode: 'LYH', id: '88' }, { name: '通化市', code: 'Tonghua Shi', shortcode: 'THS', id: '89' }, { name: '白山市', code: 'Baishan Shi', shortcode: 'BSN', id: '90' }, { name: '松原市', code: 'Songyuan Shi', shortcode: 'SYU', id: '91' }, { name: '白城市', code: 'Baicheng Shi', shortcode: 'BCS', id: '92' }, { name: '延边朝鲜族自治州', code: 'Yanbian Chosenzu Zizhizhou', shortcode: 'YBZ', id: '93' }, { name: '哈尔滨市', code: 'Harbin Shi', shortcode: 'HRB', id: '94' }, { name: '齐齐哈尔市', code: 'Qiqihar Shi', shortcode: 'NDG', id: '95' }, { name: '鸡西市', code: 'Jixi Shi', shortcode: 'JXI', id: '96' }, { name: '鹤岗市', code: 'Hegang Shi', shortcode: 'HEG', id: '97' }, { name: '双鸭山市', code: 'Shuangyashan Shi', shortcode: 'SYS', id: '98' }, { name: '大庆市', code: 'Daqing Shi', shortcode: 'DQG', id: '99' }, { name: '伊春市', code: 'Yichun Shi', shortcode: 'YCH', id: '100' }, { name: '佳木斯市', code: 'Jiamusi Shi', shortcode: 'JMU', id: '101' }, { name: '七台河市', code: 'Qitaihe Shi', shortcode: 'QTH', id: '102' }, { name: '牡丹江市', code: 'Mudanjiang Shi', shortcode: 'MDG', id: '103' }, { name: '黑河市', code: 'Heihe Shi', shortcode: 'HEK', id: '104' }, { name: '绥化市', code: 'Suihua Shi', shortcode: '2', id: '105' }, { name: '大兴安岭地区', code: 'Da Hinggan Ling Diqu', shortcode: 'DHL', id: '106' }, { name: '南京市', code: 'Nanjing Shi', shortcode: 'NKG', id: '109' }, { name: '无锡市', code: 'Wuxi Shi', shortcode: 'WUX', id: '110' }, { name: '徐州市', code: 'Xuzhou Shi', shortcode: 'XUZ', id: '111' }, { name: '常州市', code: 'Changzhou Shi', shortcode: 'CZX', id: '112' }, { name: '苏州市', code: 'Suzhou Shi', shortcode: 'SZH', id: '113' }, { name: '南通市', code: 'Nantong Shi', shortcode: 'NTG', id: '114' }, { name: '连云港市', code: 'Lianyungang Shi', shortcode: 'LYG', id: '115' }, { name: '淮安市', code: 'Huai,an Xian', shortcode: '2', id: '116' }, { name: '盐城市', code: 'Yancheng Shi', shortcode: 'YCK', id: '117' }, { name: '扬州市', code: 'Yangzhou Shi', shortcode: 'YZH', id: '118' }, { name: '镇江市', code: 'Zhenjiang Shi', shortcode: 'ZHE', id: '119' }, { name: '泰州市', code: 'Taizhou Shi', shortcode: 'TZS', id: '120' }, { name: '宿迁市', code: 'Suqian Shi', shortcode: 'SUQ', id: '121' }, { name: '杭州市', code: 'Hangzhou Shi', shortcode: 'HGH', id: '122' }, { name: '宁波市', code: 'Ningbo Shi', shortcode: 'NGB', id: '123' }, { name: '温州市', code: 'Wenzhou Shi', shortcode: 'WNZ', id: '124' }, { name: '嘉兴市', code: 'Jiaxing Shi', shortcode: 'JIX', id: '125' }, { name: '湖州市', code: 'Huzhou Shi ', shortcode: 'HZH', id: '126' }, { name: '绍兴市', code: 'Shaoxing Shi', shortcode: 'SXG', id: '127' }, { name: '金华市', code: 'Jinhua Shi', shortcode: 'JHA', id: '128' }, { name: '衢州市', code: 'Quzhou Shi', shortcode: 'QUZ', id: '129' }, { name: '舟山市', code: 'Zhoushan Shi', shortcode: 'ZOS', id: '130' }, { name: '台州市', code: 'Taizhou Shi', shortcode: 'TZZ', id: '131' }, { name: '丽水市', code: 'Lishui Shi', shortcode: '2', id: '132' }, { name: '合肥市', code: 'Hefei Shi', shortcode: 'HFE', id: '133' }, { name: '芜湖市', code: 'Wuhu Shi', shortcode: 'WHI', id: '134' }, { name: '蚌埠市', code: 'Bengbu Shi', shortcode: 'BBU', id: '135' }, { name: '淮南市', code: 'Huainan Shi', shortcode: 'HNS', id: '136' }, { name: '马鞍山市', code: 'Ma,anshan Shi', shortcode: 'MAA', id: '137' }, { name: '淮北市', code: 'Huaibei Shi', shortcode: 'HBE', id: '138' }, { name: '铜陵市', code: 'Tongling Shi', shortcode: 'TOL', id: '139' }, { name: '安庆市', code: 'Anqing Shi', shortcode: 'AQG', id: '140' }, { name: '黄山市', code: 'Huangshan Shi', shortcode: 'HSN', id: '141' }, { name: '滁州市', code: 'Chuzhou Shi', shortcode: 'CUZ', id: '142' }, { name: '阜阳市', code: 'Fuyang Shi', shortcode: 'FYS', id: '143' }, { name: '宿州市', code: 'Suzhou Shi', shortcode: 'SUZ', id: '144' }, { name: '巢湖市', code: 'Chaohu Shi', shortcode: '2', id: '145' }, { name: '六安市', code: 'Liu,an Shi', shortcode: '2', id: '146' }, { name: '亳州市', code: 'Bozhou Shi', shortcode: '2', id: '147' }, { name: '池州市', code: 'Chizhou Shi', shortcode: '2', id: '148' }, { name: '宣城市', code: 'Xuancheng Shi', shortcode: '2', id: '149' }, { name: '福州市', code: 'Fuzhou Shi', shortcode: 'FOC', id: '150' }, { name: '厦门市', code: 'Xiamen Shi', shortcode: 'XMN', id: '151' }, { name: '莆田市', code: 'Putian Shi', shortcode: 'PUT', id: '152' }, { name: '三明市', code: 'Sanming Shi', shortcode: 'SMS', id: '153' }, { name: '泉州市', code: 'Quanzhou Shi', shortcode: 'QZJ', id: '154' }, { name: '漳州市', code: 'Zhangzhou Shi', shortcode: 'ZZU', id: '155' }, { name: '南平市', code: 'Nanping Shi', shortcode: 'NPS', id: '156' }, { name: '龙岩市', code: 'Longyan Shi', shortcode: 'LYF', id: '157' }, { name: '宁德市', code: 'Ningde Shi', shortcode: '2', id: '158' }, { name: '南昌市', code: 'Nanchang Shi', shortcode: 'KHN', id: '159' }, { name: '景德镇市', code: 'Jingdezhen Shi', shortcode: 'JDZ', id: '160' }, { name: '萍乡市', code: 'Pingxiang Shi', shortcode: 'PXS', id: '161' }, { name: '九江市', code: 'Jiujiang Shi', shortcode: 'JIU', id: '162' }, { name: '新余市', code: 'Xinyu Shi', shortcode: 'XYU', id: '163' }, { name: '鹰潭市', code: 'Yingtan Shi', shortcode: '2', id: '164' }, { name: '赣州市', code: 'Ganzhou Shi', shortcode: 'GZH', id: '165' }, { name: '吉安市', code: 'Ji,an Shi', shortcode: '2', id: '166' }, { name: '宜春市', code: 'Yichun Shi', shortcode: '2', id: '167' }, { name: '抚州市', code: 'Wuzhou Shi', shortcode: '2', id: '168' }, { name: '上饶市', code: 'Shangrao Shi', shortcode: '2', id: '169' }, { name: '济南市', code: 'Jinan Shi', shortcode: 'TNA', id: '170' }, { name: '青岛市', code: 'Qingdao Shi', shortcode: 'TAO', id: '171' }, { name: '淄博市', code: 'Zibo Shi', shortcode: 'ZBO', id: '172' }, { name: '枣庄市', code: 'Zaozhuang Shi', shortcode: 'ZZG', id: '173' }, { name: '东营市', code: 'Dongying Shi', shortcode: 'DYG', id: '174' }, { name: '烟台市', code: 'Yantai Shi', shortcode: 'YNT', id: '175' }, { name: '潍坊市', code: 'Weifang Shi', shortcode: 'WEF', id: '176' }, { name: '济宁市', code: 'Jining Shi', shortcode: 'JNG', id: '177' }, { name: '泰安市', code: 'Tai,an Shi', shortcode: 'TAI', id: '178' }, { name: '威海市', code: 'Weihai Shi', shortcode: 'WEH', id: '179' }, { name: '日照市', code: 'Rizhao Shi', shortcode: 'RZH', id: '180' }, { name: '莱芜市', code: 'Laiwu Shi', shortcode: 'LWS', id: '181' }, { name: '临沂市', code: 'Linyi Shi', shortcode: 'LYI', id: '182' }, { name: '德州市', code: 'Dezhou Shi', shortcode: 'DZS', id: '183' }, { name: '聊城市', code: 'Liaocheng Shi', shortcode: 'LCH', id: '184' }, { name: '滨州市', code: 'Binzhou Shi', shortcode: '2', id: '185' }, { name: '菏泽市', code: 'Heze Shi', shortcode: 'HZ', id: '186' }, { name: '郑州市', code: 'Zhengzhou Shi', shortcode: 'CGO', id: '187' }, { name: '开封市', code: 'Kaifeng Shi', shortcode: 'KFS', id: '188' }, { name: '洛阳市', code: 'Luoyang Shi', shortcode: 'LYA', id: '189' }, { name: '平顶山市', code: 'Pingdingshan Shi', shortcode: 'PDS', id: '190' }, { name: '安阳市', code: 'Anyang Shi', shortcode: 'AYS', id: '191' }, { name: '鹤壁市', code: 'Hebi Shi', shortcode: 'HBS', id: '192' }, { name: '新乡市', code: 'Xinxiang Shi', shortcode: 'XXS', id: '193' }, { name: '焦作市', code: 'Jiaozuo Shi', shortcode: 'JZY', id: '194' }, { name: '濮阳市', code: 'Puyang Shi', shortcode: 'PYS', id: '195' }, { name: '许昌市', code: 'Xuchang Shi', shortcode: 'XCS', id: '196' }, { name: '漯河市', code: 'Luohe Shi', shortcode: 'LHS', id: '197' }, { name: '三门峡市', code: 'Sanmenxia Shi', shortcode: 'SMX', id: '198' }, { name: '南阳市', code: 'Nanyang Shi', shortcode: 'NYS', id: '199' }, { name: '商丘市', code: 'Shangqiu Shi', shortcode: 'SQS', id: '200' }, { name: '信阳市', code: 'Xinyang Shi', shortcode: 'XYG', id: '201' }, { name: '周口市', code: 'Zhoukou Shi', shortcode: '2', id: '202' }, { name: '驻马店市', code: 'Zhumadian Shi', shortcode: '2', id: '203' }, { name: '武汉市', code: 'Wuhan Shi', shortcode: 'WUH', id: '204' }, { name: '黄石市', code: 'Huangshi Shi', shortcode: 'HIS', id: '205' }, { name: '十堰市', code: 'Shiyan Shi', shortcode: 'SYE', id: '206' }, { name: '宜昌市', code: 'Yichang Shi', shortcode: 'YCO', id: '207' }, { name: '襄樊市', code: 'Xiangfan Shi', shortcode: 'XFN', id: '208' }, { name: '鄂州市', code: 'Ezhou Shi', shortcode: 'EZS', id: '209' }, { name: '荆门市', code: 'Jingmen Shi', shortcode: 'JMS', id: '210' }, { name: '孝感市', code: 'Xiaogan Shi', shortcode: 'XGE', id: '211' }, { name: '荆州市', code: 'Jingzhou Shi', shortcode: 'JGZ', id: '212' }, { name: '黄冈市', code: 'Huanggang Shi', shortcode: 'HE', id: '213' }, { name: '咸宁市', code: 'Xianning Xian', shortcode: 'XNS', id: '214' }, { name: '随州市', code: 'Suizhou Shi', shortcode: '2', id: '215' }, { name: '恩施土家族苗族自治州', code: 'Enshi Tujiazu Miaozu Zizhizhou', shortcode: 'ESH', id: '216' }, { name: '省直辖县级行政区划', code: 'shengzhixiaxianjixingzhengquhua', shortcode: '2', id: '217' }, { name: '长沙市', code: 'Changsha Shi', shortcode: 'CSX', id: '218' }, { name: '株洲市', code: 'Zhuzhou Shi', shortcode: 'ZZS', id: '219' }, { name: '湘潭市', code: 'Xiangtan Shi', shortcode: 'XGT', id: '220' }, { name: '衡阳市', code: 'Hengyang Shi', shortcode: 'HNY', id: '221' }, { name: '邵阳市', code: 'Shaoyang Shi', shortcode: 'SYR', id: '222' }, { name: '岳阳市', code: 'Yueyang Shi', shortcode: 'YYG', id: '223' }, { name: '常德市', code: 'Changde Shi', shortcode: 'CDE', id: '224' }, { name: '张家界市', code: 'Zhangjiajie Shi', shortcode: 'ZJJ', id: '225' }, { name: '益阳市', code: 'Yiyang Shi', shortcode: 'YYS', id: '226' }, { name: '郴州市', code: 'Chenzhou Shi', shortcode: 'CNZ', id: '227' }, { name: '永州市', code: 'Yongzhou Shi', shortcode: 'YZS', id: '228' }, { name: '怀化市', code: 'Huaihua Shi', shortcode: 'HHS', id: '229' }, { name: '娄底市', code: 'Loudi Shi', shortcode: '2', id: '230' }, { name: '湘西土家族苗族自治州', code: 'Xiangxi Tujiazu Miaozu Zizhizhou ', shortcode: 'XXZ', id: '231' }, { name: '广州市', code: 'Guangzhou Shi', shortcode: 'CAN', id: '232' }, { name: '韶关市', code: 'Shaoguan Shi', shortcode: 'HSC', id: '233' }, { name: '深圳市', code: 'Shenzhen Shi', shortcode: 'SZX', id: '234' }, { name: '珠海市', code: 'Zhuhai Shi', shortcode: 'ZUH', id: '235' }, { name: '汕头市', code: 'Shantou Shi', shortcode: 'SWA', id: '236' }, { name: '佛山市', code: 'Foshan Shi', shortcode: 'FOS', id: '237' }, { name: '江门市', code: 'Jiangmen Shi', shortcode: 'JMN', id: '238' }, { name: '湛江市', code: 'Zhanjiang Shi', shortcode: 'ZHA', id: '239' }, { name: '茂名市', code: 'Maoming Shi', shortcode: 'MMI', id: '240' }, { name: '肇庆市', code: 'Zhaoqing Shi', shortcode: 'ZQG', id: '241' }, { name: '惠州市', code: 'Huizhou Shi', shortcode: 'HUI', id: '242' }, { name: '梅州市', code: 'Meizhou Shi', shortcode: 'MXZ', id: '243' }, { name: '汕尾市', code: 'Shanwei Shi', shortcode: 'SWE', id: '244' }, { name: '河源市', code: 'Heyuan Shi', shortcode: 'HEY', id: '245' }, { name: '阳江市', code: 'Yangjiang Shi', shortcode: 'YJI', id: '246' }, { name: '清远市', code: 'Qingyuan Shi', shortcode: 'QYN', id: '247' }, { name: '东莞市', code: 'Dongguan Shi', shortcode: 'DGG', id: '248' }, { name: '中山市', code: 'Zhongshan Shi', shortcode: 'ZSN', id: '249' }, { name: '潮州市', code: 'Chaozhou Shi', shortcode: 'CZY', id: '250' }, { name: '揭阳市', code: 'Jieyang Shi', shortcode: 'JIY', id: '251' }, { name: '云浮市', code: 'Yunfu Shi', shortcode: 'YFS', id: '252' }, { name: '南宁市', code: 'Nanning Shi', shortcode: 'NNG', id: '253' }, { name: '柳州市', code: 'Liuzhou Shi', shortcode: 'LZH', id: '254' }, { name: '桂林市', code: 'Guilin Shi', shortcode: 'KWL', id: '255' }, { name: '梧州市', code: 'Wuzhou Shi', shortcode: 'WUZ', id: '256' }, { name: '北海市', code: 'Beihai Shi', shortcode: 'BHY', id: '257' }, { name: '防城港市', code: 'Fangchenggang Shi', shortcode: 'FAN', id: '258' }, { name: '钦州市', code: 'Qinzhou Shi', shortcode: 'QZH', id: '259' }, { name: '贵港市', code: 'Guigang Shi', shortcode: 'GUG', id: '260' }, { name: '玉林市', code: 'Yulin Shi', shortcode: 'YUL', id: '261' }, { name: '百色市', code: 'Baise Shi', shortcode: '2', id: '262' }, { name: '贺州市', code: 'Hezhou Shi', shortcode: '2', id: '263' }, { name: '河池市', code: 'Hechi Shi', shortcode: '2', id: '264' }, { name: '来宾市', code: 'Laibin Shi', shortcode: '2', id: '265' }, { name: '崇左市', code: 'Chongzuo Shi', shortcode: '2', id: '266' }, { name: '海口市', code: 'Haikou Shi', shortcode: 'HAK', id: '267' }, { name: '三亚市', code: 'Sanya Shi', shortcode: 'SYX', id: '268' }, { name: '省直辖县级行政区划', code: 'shengzhixiaxianjixingzhengquhua', shortcode: '2', id: '269' }, { name: '成都市', code: 'Chengdu Shi', shortcode: 'CTU', id: '273' }, { name: '自贡市', code: 'Zigong Shi', shortcode: 'ZGS', id: '274' }, { name: '攀枝花市', code: 'Panzhihua Shi', shortcode: 'PZH', id: '275' }, { name: '泸州市', code: 'Luzhou Shi', shortcode: 'LUZ', id: '276' }, { name: '德阳市', code: 'Deyang Shi', shortcode: 'DEY', id: '277' }, { name: '绵阳市', code: 'Mianyang Shi', shortcode: 'MYG', id: '278' }, { name: '广元市', code: 'Guangyuan Shi', shortcode: 'GYC', id: '279' }, { name: '遂宁市', code: 'Suining Shi', shortcode: 'SNS', id: '280' }, { name: '内江市', code: 'Neijiang Shi', shortcode: 'NJS', id: '281' }, { name: '乐山市', code: 'Leshan Shi', shortcode: 'LES', id: '282' }, { name: '南充市', code: 'Nanchong Shi', shortcode: 'NCO', id: '283' }, { name: '眉山市', code: 'Meishan Shi', shortcode: '2', id: '284' }, { name: '宜宾市', code: 'Yibin Shi', shortcode: 'YBS', id: '285' }, { name: '广安市', code: 'Guang,an Shi', shortcode: 'GAC', id: '286' }, { name: '达州市', code: 'Dazhou Shi', shortcode: '2', id: '287' }, { name: '雅安市', code: 'Ya,an Shi', shortcode: '2', id: '288' }, { name: '巴中市', code: 'Bazhong Shi', shortcode: '2', id: '289' }, { name: '资阳市', code: 'Ziyang Shi', shortcode: '2', id: '290' }, { name: '阿坝藏族羌族自治州', code: 'Aba(Ngawa) Zangzu Qiangzu Zizhizhou', shortcode: 'ABA', id: '291' }, { name: '甘孜藏族自治州', code: 'Garze Zangzu Zizhizhou', shortcode: 'GAZ', id: '292' }, { name: '凉山彝族自治州', code: 'Liangshan Yizu Zizhizhou', shortcode: 'LSY', id: '293' }, { name: '贵阳市', code: 'Guiyang Shi', shortcode: 'KWE', id: '294' }, { name: '六盘水市', code: 'Liupanshui Shi', shortcode: 'LPS', id: '295' }, { name: '遵义市', code: 'Zunyi Shi', shortcode: 'ZNY', id: '296' }, { name: '安顺市', code: 'Anshun Xian', shortcode: '2', id: '297' }, { name: '铜仁地区', code: 'Tongren Diqu', shortcode: 'TRD', id: '298' }, { name: '黔西南布依族苗族自治州', code: 'Qianxinan Buyeizu Zizhizhou', shortcode: 'QXZ', id: '299' }, { name: '毕节地区', code: 'Bijie Diqu', shortcode: 'BJD', id: '300' }, { name: '黔东南苗族侗族自治州', code: 'Qiandongnan Miaozu Dongzu Zizhizhou', shortcode: 'QND', id: '301' }, { name: '黔南布依族苗族自治州', code: 'Qiannan Buyeizu Miaozu Zizhizhou', shortcode: 'QNZ', id: '302' }, { name: '昆明市', code: 'Kunming Shi', shortcode: 'KMG', id: '303' }, { name: '曲靖市', code: 'Qujing Shi', shortcode: 'QJS', id: '304' }, { name: '玉溪市', code: 'Yuxi Shi', shortcode: 'YXS', id: '305' }, { name: '保山市', code: 'Baoshan Shi', shortcode: '2', id: '306' }, { name: '昭通市', code: 'Zhaotong Shi', shortcode: '2', id: '307' }, { name: '丽江市', code: 'Lijiang Shi', shortcode: '2', id: '308' }, { name: '普洱市', code: 'Simao Shi', shortcode: '2', id: '309' }, { name: '临沧市', code: 'Lincang Shi', shortcode: '2', id: '310' }, { name: '楚雄彝族自治州', code: 'Chuxiong Yizu Zizhizhou', shortcode: 'CXD', id: '311' }, { name: '红河哈尼族彝族自治州', code: 'Honghe Hanizu Yizu Zizhizhou', shortcode: 'HHZ', id: '312' }, { name: '文山壮族苗族自治州', code: 'Wenshan Zhuangzu Miaozu Zizhizhou', shortcode: 'WSZ', id: '313' }, { name: '西双版纳傣族自治州', code: 'Xishuangbanna Daizu Zizhizhou', shortcode: 'XSB', id: '314' }, { name: '大理白族自治州', code: 'Dali Baizu Zizhizhou', shortcode: 'DLZ', id: '315' }, { name: '德宏傣族景颇族自治州', code: 'Dehong Daizu Jingpozu Zizhizhou', shortcode: 'DHG', id: '316' }, { name: '怒江傈僳族自治州', code: 'Nujiang Lisuzu Zizhizhou', shortcode: 'NUJ', id: '317' }, { name: '迪庆藏族自治州', code: 'Deqen Zangzu Zizhizhou', shortcode: 'DEZ', id: '318' }, { name: '拉萨市', code: 'Lhasa Shi', shortcode: 'LXA', id: '319' }, { name: '昌都地区', code: 'Qamdo Diqu', shortcode: 'QAD', id: '320' }, { name: '山南地区', code: 'Shannan Diqu', shortcode: 'SND', id: '321' }, { name: '日喀则地区', code: 'Xigaze Diqu', shortcode: 'XID', id: '322' }, { name: '那曲地区', code: 'Nagqu Diqu', shortcode: 'NAD', id: '323' }, { name: '阿里地区', code: 'Ngari Diqu', shortcode: 'NGD', id: '324' }, { name: '林芝地区', code: 'Nyingchi Diqu', shortcode: 'NYD', id: '325' }, { name: '西安市', code: 'Xi,an Shi', shortcode: 'SIA', id: '326' }, { name: '铜川市', code: 'Tongchuan Shi', shortcode: 'TCN', id: '327' }, { name: '宝鸡市', code: 'Baoji Shi', shortcode: 'BJI', id: '328' }, { name: '咸阳市', code: 'Xianyang Shi', shortcode: 'XYS', id: '329' }, { name: '渭南市', code: 'Weinan Shi', shortcode: 'WNA', id: '330' }, { name: '延安市', code: 'Yan,an Shi', shortcode: 'YNA', id: '331' }, { name: '汉中市', code: 'Hanzhong Shi', shortcode: 'HZJ', id: '332' }, { name: '榆林市', code: 'Yulin Shi', shortcode: '2', id: '333' }, { name: '安康市', code: 'Ankang Shi', shortcode: '2', id: '334' }, { name: '商洛市', code: 'Shangluo Shi', shortcode: '2', id: '335' }, { name: '兰州市', code: 'Lanzhou Shi', shortcode: 'LHW', id: '336' }, { name: '嘉峪关市', code: 'Jiayuguan Shi', shortcode: 'JYG', id: '337' }, { name: '金昌市', code: 'Jinchang Shi', shortcode: 'JCS', id: '338' }, { name: '白银市', code: 'Baiyin Shi', shortcode: 'BYS', id: '339' }, { name: '天水市', code: 'Tianshui Shi', shortcode: 'TSU', id: '340' }, { name: '武威市', code: 'Wuwei Shi', shortcode: '2', id: '341' }, { name: '张掖市', code: 'Zhangye Shi', shortcode: '2', id: '342' }, { name: '平凉市', code: 'Pingliang Shi', shortcode: '2', id: '343' }, { name: '酒泉市', code: 'Jiuquan Shi', shortcode: '2', id: '344' }, { name: '庆阳市', code: 'Qingyang Shi', shortcode: '2', id: '345' }, { name: '定西市', code: 'Dingxi Shi', shortcode: '2', id: '346' }, { name: '陇南市', code: 'Longnan Shi', shortcode: '2', id: '347' }, { name: '临夏回族自治州', code: 'Linxia Huizu Zizhizhou ', shortcode: 'LXH', id: '348' }, { name: '甘南藏族自治州', code: 'Gannan Zangzu Zizhizhou', shortcode: 'GNZ', id: '349' }, { name: '西宁市', code: 'Xining Shi', shortcode: 'XNN', id: '350' }, { name: '海东地区', code: 'Haidong Diqu', shortcode: 'HDD', id: '351' }, { name: '海北藏族自治州', code: 'Haibei Zangzu Zizhizhou', shortcode: 'HBZ', id: '352' }, { name: '黄南藏族自治州', code: 'Huangnan Zangzu Zizhizhou', shortcode: 'HNZ', id: '353' }, { name: '海南藏族自治州', code: 'Hainan Zangzu Zizhizhou', shortcode: 'HNN', id: '354' }, { name: '果洛藏族自治州', code: 'Golog Zangzu Zizhizhou', shortcode: 'GOL', id: '355' }, { name: '玉树藏族自治州', code: 'Yushu Zangzu Zizhizhou', shortcode: 'YSZ', id: '356' }, { name: '海西蒙古族藏族自治州', code: 'Haixi Mongolzu Zangzu Zizhizhou', shortcode: 'HXZ', id: '357' }, { name: '银川市', code: 'Yinchuan Shi', shortcode: 'INC', id: '358' }, { name: '石嘴山市', code: 'Shizuishan Shi', shortcode: 'SZS', id: '359' }, { name: '吴忠市', code: 'Wuzhong Shi', shortcode: 'WZS', id: '360' }, { name: '固原市', code: 'Guyuan Shi', shortcode: '2', id: '361' }, { name: '中卫市', code: 'Zhongwei Shi', shortcode: '2', id: '362' }, { name: '乌鲁木齐市', code: 'Urumqi Shi', shortcode: 'URC', id: '363' }, { name: '克拉玛依市', code: 'Karamay Shi', shortcode: 'KAR', id: '364' }, { name: '吐鲁番地区', code: 'Turpan Diqu', shortcode: 'TUD', id: '365' }, { name: '哈密地区', code: 'Hami(kumul) Diqu', shortcode: 'HMD', id: '366' }, { name: '昌吉回族自治州', code: 'Changji Huizu Zizhizhou', shortcode: 'CJZ', id: '367' }, { name: '博尔塔拉蒙古自治州', code: 'Bortala Monglo Zizhizhou', shortcode: 'BOR', id: '368' }, { name: '巴音郭楞蒙古自治州', code: 'bayinguolengmengguzizhizhou', shortcode: '2', id: '369' }, { name: '阿克苏地区', code: 'Aksu Diqu', shortcode: 'AKD', id: '370' }, { name: '克孜勒苏柯尔克孜自治州', code: 'Kizilsu Kirgiz Zizhizhou', shortcode: 'KIZ', id: '371' }, { name: '喀什地区', code: 'Kashi(Kaxgar) Diqu', shortcode: 'KSI', id: '372' }, { name: '和田地区', code: 'Hotan Diqu', shortcode: 'HOD', id: '373' }, { name: '伊犁哈萨克自治州', code: 'Ili Kazak Zizhizhou', shortcode: 'ILD', id: '374' }, { name: '塔城地区', code: 'Tacheng(Qoqek) Diqu', shortcode: 'TCD', id: '375' }, { name: '阿勒泰地区', code: 'Altay Diqu', shortcode: 'ALD', id: '376' }, { name: '自治区直辖县级行政区划', code: 'zizhiquzhixiaxianjixingzhengquhua', shortcode: '2', id: '377' }, { name: '东城区', code: 'Dongcheng Qu', shortcode: 'DCQ', id: '378' }, { name: '西城区', code: 'Xicheng Qu', shortcode: 'XCQ', id: '379' }, { name: '朝阳区', code: 'Chaoyang Qu', shortcode: 'CYQ', id: '382' }, { name: '丰台区', code: 'Fengtai Qu', shortcode: 'FTQ', id: '383' }, { name: '石景山区', code: 'Shijingshan Qu', shortcode: 'SJS', id: '384' }, { name: '海淀区', code: 'Haidian Qu', shortcode: 'HDN', id: '385' }, { name: '门头沟区', code: 'Mentougou Qu', shortcode: 'MTG', id: '386' }, { name: '房山区', code: 'Fangshan Qu', shortcode: 'FSQ', id: '387' }, { name: '通州区', code: 'Tongzhou Qu', shortcode: 'TZQ', id: '388' }, { name: '顺义区', code: 'Shunyi Qu', shortcode: 'SYI', id: '389' }, { name: '昌平区', code: 'Changping Qu', shortcode: 'CP Q', id: '390' }, { name: '大兴区', code: 'Daxing Qu', shortcode: 'DX Q', id: '391' }, { name: '怀柔区', code: 'Huairou Qu', shortcode: 'HR Q', id: '392' }, { name: '平谷区', code: 'Pinggu Qu', shortcode: 'PG Q', id: '393' }, { name: '密云县', code: 'Miyun Xian ', shortcode: 'MYN', id: '394' }, { name: '延庆县', code: 'Yanqing Xian', shortcode: 'YQX', id: '395' }, { name: '和平区', code: 'Heping Qu', shortcode: 'HPG', id: '396' }, { name: '河东区', code: 'Hedong Qu', shortcode: 'HDQ', id: '397' }, { name: '河西区', code: 'Hexi Qu', shortcode: 'HXQ', id: '398' }, { name: '南开区', code: 'Nankai Qu', shortcode: 'NKQ', id: '399' }, { name: '河北区', code: 'Hebei Qu', shortcode: 'HBQ', id: '400' }, { name: '红桥区', code: 'Hongqiao Qu', shortcode: 'HQO', id: '401' }, { name: '滨海新区', code: 'Dagang Qu', shortcode: '2', id: '404' }, { name: '东丽区', code: 'Dongli Qu', shortcode: 'DLI', id: '405' }, { name: '西青区', code: 'Xiqing Qu', shortcode: 'XQG', id: '406' }, { name: '津南区', code: 'Jinnan Qu', shortcode: 'JNQ', id: '407' }, { name: '北辰区', code: 'Beichen Qu', shortcode: 'BCQ', id: '408' }, { name: '武清区', code: 'Wuqing Qu', shortcode: 'WQ Q', id: '409' }, { name: '宝坻区', code: 'Baodi Qu', shortcode: 'BDI', id: '410' }, { name: '宁河县', code: 'Ninghe Xian', shortcode: 'NHE', id: '411' }, { name: '静海县', code: 'Jinghai Xian', shortcode: 'JHT', id: '412' }, { name: '蓟县', code: 'Ji Xian', shortcode: 'JIT', id: '413' }, { name: '黄浦区', code: 'Huangpu Qu', shortcode: 'HGP', id: '1160' }, { name: '卢湾区', code: 'Luwan Qu', shortcode: 'LWN', id: '1161' }, { name: '徐汇区', code: 'Xuhui Qu', shortcode: 'XHI', id: '1162' }, { name: '长宁区', code: 'Changning Qu', shortcode: 'CNQ', id: '1163' }, { name: '静安区', code: 'Jing,an Qu', shortcode: 'JAQ', id: '1164' }, { name: '普陀区', code: 'Putuo Qu', shortcode: 'PTQ', id: '1165' }, { name: '闸北区', code: 'Zhabei Qu', shortcode: 'ZBE', id: '1166' }, { name: '虹口区', code: 'Hongkou Qu', shortcode: 'HKQ', id: '1167' }, { name: '杨浦区', code: 'Yangpu Qu', shortcode: 'YPU', id: '1168' }, { name: '闵行区', code: 'Minhang Qu', shortcode: 'MHQ', id: '1169' }, { name: '宝山区', code: 'Baoshan Qu', shortcode: 'BAO', id: '1170' }, { name: '嘉定区', code: 'Jiading Qu', shortcode: 'JDG', id: '1171' }, { name: '浦东新区', code: 'Pudong Xinqu', shortcode: 'PDX', id: '1172' }, { name: '金山区', code: 'Jinshan Qu', shortcode: 'JSH', id: '1173' }, { name: '松江区', code: 'Songjiang Qu', shortcode: 'SOJ', id: '1174' }, { name: '青浦区', code: 'Qingpu  Qu', shortcode: 'QPU', id: '1175' }, { name: '奉贤区', code: 'Fengxian Qu', shortcode: 'FXI', id: '1177' }, { name: '崇明县', code: 'Chongming Xian', shortcode: 'CMI', id: '1178' }, { name: '万州区', code: 'Wanzhou Qu', shortcode: 'WZO ', id: '2595' }, { name: '涪陵区', code: 'Fuling Qu', shortcode: 'FLG', id: '2596' }, { name: '渝中区', code: 'Yuzhong Qu', shortcode: 'YZQ', id: '2597' }, { name: '大渡口区', code: 'Dadukou Qu', shortcode: 'DDK', id: '2598' }, { name: '江北区', code: 'Jiangbei Qu', shortcode: 'JBE', id: '2599' }, { name: '沙坪坝区', code: 'Shapingba Qu', shortcode: 'SPB', id: '2600' }, { name: '九龙坡区', code: 'Jiulongpo Qu', shortcode: 'JLP', id: '2601' }, { name: '南岸区', code: 'Nan,an Qu', shortcode: 'NAQ', id: '2602' }, { name: '北碚区', code: 'Beibei Qu', shortcode: 'BBE', id: '2603' }, { name: '万盛区', code: 'Wansheng Qu', shortcode: 'WSQ', id: '2604' }, { name: '双桥区', code: 'Shuangqiao Qu', shortcode: 'SQQ', id: '2605' }, { name: '渝北区', code: 'Yubei Qu', shortcode: 'YBE', id: '2606' }, { name: '巴南区', code: 'Banan Qu', shortcode: 'BNN', id: '2607' }, { name: '黔江区', code: 'Qianjiang Qu', shortcode: '2', id: '2608' }, { name: '长寿区', code: 'Changshou Qu', shortcode: '2', id: '2609' }, { name: '綦江县', code: 'Qijiang Xian', shortcode: 'QJG', id: '2610' }, { name: '潼南县', code: 'Tongnan Xian', shortcode: 'TNN', id: '2611' }, { name: '铜梁县', code: 'Tongliang Xian', shortcode: 'TGL', id: '2612' }, { name: '大足县', code: 'Dazu Xian', shortcode: 'DZX', id: '2613' }, { name: '荣昌县', code: 'Rongchang Xian', shortcode: 'RGC', id: '2614' }, { name: '璧山县', code: 'Bishan Xian', shortcode: 'BSY', id: '2615' }, { name: '梁平县', code: 'Liangping Xian', shortcode: 'LGP', id: '2616' }, { name: '城口县', code: 'Chengkou Xian', shortcode: 'CKO', id: '2617' }, { name: '丰都县', code: 'Fengdu Xian', shortcode: 'FDU', id: '2618' }, { name: '垫江县', code: 'Dianjiang Xian', shortcode: 'DJG', id: '2619' }, { name: '武隆县', code: 'Wulong Xian', shortcode: 'WLG', id: '2620' }, { name: '忠县', code: 'Zhong Xian', shortcode: 'ZHX', id: '2621' }, { name: '开县', code: 'Kai Xian', shortcode: 'KAI', id: '2622' }, { name: '云阳县', code: 'Yunyang Xian', shortcode: 'YNY', id: '2623' }, { name: '奉节县', code: 'Fengjie Xian', shortcode: 'FJE', id: '2624' }, { name: '巫山县', code: 'Wushan Xian', shortcode: 'WSN', id: '2625' }, { name: '巫溪县', code: 'Wuxi Xian', shortcode: 'WXX', id: '2626' }, { name: '石柱土家族自治县', code: 'Shizhu Tujiazu Zizhixian', shortcode: 'SZY', id: '2627' }, { name: '秀山土家族苗族自治县', code: 'Xiushan Tujiazu Miaozu Zizhixian', shortcode: 'XUS', id: '2628' }, { name: '酉阳土家族苗族自治县', code: 'Youyang Tujiazu Miaozu Zizhixian', shortcode: 'YUY', id: '2629' }, { name: '彭水苗族土家族自治县', code: 'Pengshui Miaozu Tujiazu Zizhixian', shortcode: 'PSU', id: '2630' }, { name: '江津区', code: 'Jiangjin Qu', shortcode: '2', id: '4001' }, { name: '合川区', code: 'Hechuan Qu', shortcode: '2', id: '4002' }, { name: '永川区', code: 'Yongchuan Qu', shortcode: '2', id: '4003' }, { name: '南川区', code: 'Nanchuan Qu', shortcode: '2', id: '4004' }];
Vcity._m = {
    /* 选择元素 */
    $: function (arg, context) {
        var tagAll, n, eles = [], i, sub = arg.substring(1);
        context = context || document;
        if (typeof arg == 'string') {
            switch (arg.charAt(0)) {
                case '#':
                    return document.getElementById(sub);
                    break;
                case '.':
                    if (context.getElementsByClassName) return context.getElementsByClassName(sub);
                    tagAll = Vcity._m.$('*', context);
                    n = tagAll.length;
                    for (i = 0; i < n; i++) {
                        if (tagAll[i].className.indexOf(sub) > -1) eles.push(tagAll[i]);
                    }
                    return eles;
                    break;
                default:
                    return context.getElementsByTagName(arg);
                    break;
            }
        }
    },

    exitCity: function (value, city) {        
        var reg = new RegExp("^" + value, 'gi');       
        if (reg.test(city.name) || reg.test(city.code) || reg.test(city.shortcode)) {
            return true;
        }
        return false;
    },

    /* 绑定事件 */
    on: function (node, type, handler) {
        node.addEventListener ? node.addEventListener(type, handler, false) : node.attachEvent('on' + type, handler);
    },

    /* 获取事件 */
    getEvent: function (event) {
        return event || window.event;
    },

    /* 获取事件目标 */
    getTarget: function (event) {
        return event.target || event.srcElement;
    },

    /* 获取元素位置 */
    getPos: function (node) {
        var scrollx = document.documentElement.scrollLeft || document.body.scrollLeft,
                scrollt = document.documentElement.scrollTop || document.body.scrollTop;
        var pos = node.getBoundingClientRect();
        return { top: pos.top + scrollt, right: pos.right + scrollx, bottom: pos.bottom + scrollt, left: pos.left + scrollx }
    },

    /* 添加样式名 */
    addClass: function (c, node) {
        if (!node) return;
        node.className = Vcity._m.hasClass(c, node) ? node.className : node.className + ' ' + c;
    },

    /* 移除样式名 */
    removeClass: function (c, node) {
        var reg = new RegExp("(^|\\s+)" + c + "(\\s+|$)", "g");
        if (!Vcity._m.hasClass(c, node)) return;
        node.className = reg.test(node.className) ? node.className.replace(reg, '') : node.className;
    },

    /* 是否含有CLASS */
    hasClass: function (c, node) {
        if (!node || !node.className) return false;
        return node.className.indexOf(c) > -1;
    },

    /* 阻止冒泡 */
    stopPropagation: function (event) {
        event = event || window.event;
        event.stopPropagation ? event.stopPropagation() : event.cancelBubble = true;
    },
    /* 去除两端空格 */
    trim: function (str) {
        return str.replace(/^\s+|\s+$/g, '');
    }
};

/* 所有城市数据,可以按照格式自行添加（北京|beijing|bj），前16条为热门城市 */



/* 正则表达式 筛选中文城市名、拼音、首字母 */
Vcity.regExChiese = /([\u4E00-\u9FA5\uf900-\ufa2d]+)/;


/* *
 * 格式化城市数组为对象oCity，按照a-h,i-p,q-z,hot热门城市分组：
 * {HOT:{hot:[]},ABCDEFGH:{a:[1,2,3],b:[1,2,3]},IJKLMNOP:{i:[1.2.3],j:[1,2,3]},QRSTUVWXYZ:{}}
 * */
(function () {
    var citys = allCity, match, letter,

            reg2 = /^[a-b]$/i, reg3 = /^[c-d]$/i, reg4 = /^[e-g]$/i, reg5 = /^[h]$/i, reg6 = /^[j]$/i, reg7 = /^[k-l]$/i, reg8 = /^[m-p]$/i, reg9 = /^[q-r]$/i, reg10 = /^[s]$/i, reg11 = /^[t]$/i, reg12 = /^[w]$/i, reg13 = /^[x]$/i, reg14 = /^[y]$/i, reg15 = /^[z]$/i;
    if (!Vcity.oCity) {
        Vcity.oCity = { hot: {}, AB: {}, CD: {}, EFG: {}, H: {}, J: {}, KL: {}, MNP: {}, QR: {}, S: {}, T: {}, W: {}, X: {}, Y: {}, Z: {} };
        //console.log(citys.length);
        for (var i = 0, n = citys.length; i < n; i++) {
            match = citys[i];
            letter = match.shortcode.toUpperCase().substr(0, 1);
            if (reg2.test(letter)) {
                if (!Vcity.oCity.AB[letter]) Vcity.oCity.AB[letter] = [];
                Vcity.oCity.AB[letter].push(match);
            } else if (reg3.test(letter)) {
                if (!Vcity.oCity.CD[letter]) Vcity.oCity.CD[letter] = [];
                Vcity.oCity.CD[letter].push(match);
            } else if (reg4.test(letter)) {
                if (!Vcity.oCity.EFG[letter]) Vcity.oCity.EFG[letter] = [];
                Vcity.oCity.EFG[letter].push(match);
            } else if (reg5.test(letter)) {
                if (!Vcity.oCity.H[letter]) Vcity.oCity.H[letter] = [];
                Vcity.oCity.H[letter].push(match);
            } else if (reg6.test(letter)) {
                if (!Vcity.oCity.J[letter]) Vcity.oCity.J[letter] = [];
                Vcity.oCity.J[letter].push(match);
            } else if (reg7.test(letter)) {
                if (!Vcity.oCity.KL[letter]) Vcity.oCity.KL[letter] = [];
                Vcity.oCity.KL[letter].push(match);
            } else if (reg8.test(letter)) {
                if (!Vcity.oCity.MNP[letter]) Vcity.oCity.MNP[letter] = [];
                Vcity.oCity.MNP[letter].push(match);
            } else if (reg9.test(letter)) {
                if (!Vcity.oCity.QR[letter]) Vcity.oCity.QR[letter] = [];
                Vcity.oCity.QR[letter].push(match);
            } else if (reg10.test(letter)) {
                if (!Vcity.oCity.S[letter]) Vcity.oCity.S[letter] = [];
                Vcity.oCity.S[letter].push(match);
            } else if (reg11.test(letter)) {
                if (!Vcity.oCity.T[letter]) Vcity.oCity.T[letter] = [];
                Vcity.oCity.T[letter].push(match);
            } else if (reg12.test(letter)) {
                if (!Vcity.oCity.W[letter]) Vcity.oCity.W[letter] = [];
                Vcity.oCity.W[letter].push(match);
            } else if (reg13.test(letter)) {
                if (!Vcity.oCity.X[letter]) Vcity.oCity.X[letter] = [];
                Vcity.oCity.X[letter].push(match);
            } else if (reg14.test(letter)) {
                if (!Vcity.oCity.Y[letter]) Vcity.oCity.Y[letter] = [];
                Vcity.oCity.Y[letter].push(match);
            } else if (reg15.test(letter)) {
                if (!Vcity.oCity.Z[letter]) Vcity.oCity.Z[letter] = [];
                Vcity.oCity.Z[letter].push(match);
            }

            /* 热门城市 前16条 */
            if (i < 20) {
                if (!Vcity.oCity.hot['hot']) Vcity.oCity.hot['hot'] = [];
                Vcity.oCity.hot['hot'].push(match);
            }
        }
    }
})();


/* 城市HTML模板 */
Vcity._template = [
    '<p class="tip">直接输入可搜索城市(支持汉字/拼音)</p>',
    '<ul>',
    '<li class="on">热门城市</li>',
    '<li>AB</li>',
    '<li>CD</li>',
    '<li>EFG</li>',
    '<li>H</li>',
    '<li>J</li>',
    '<li>KL</li>',
    '<li>MNP</li>',
    '<li>QR</li>',
    '<li>S</li>',
    '<li>T</li>',
    '<li>W</li>',
    '<li>X</li>',
    '<li>Y</li>',
    '<li>Z</li>',
    '</ul>'
];

/* *
 * 城市控件构造函数
 * @CitySelector
 * */

Vcity.CitySelector = function () {
    this.initialize.apply(this, arguments);
};

Vcity.CitySelector.prototype = {

    constructor: Vcity.CitySelector,

    /* 初始化 */

    initialize: function (options) {
        var input = options.input;
        this.input = Vcity._m.$('#' + input);
        this.inputEvent();
    },

    /* *
        

    /* *
     * @createWarp
     * 创建城市BOX HTML 框架
     * */

    createWarp: function () {
        var inputPos = Vcity._m.getPos(this.input);
        var div = this.rootDiv = document.createElement('div');
        var that = this;

        // 设置DIV阻止冒泡
        Vcity._m.on(this.rootDiv, 'click', function (event) {
            Vcity._m.stopPropagation(event);
        });

        // 设置点击文档隐藏弹出的城市选择框
        Vcity._m.on(document, 'click', function (event) {
            event = Vcity._m.getEvent(event);
            var target = Vcity._m.getTarget(event);
            if (target == that.input) return false;
            //console.log(target.className);
            if (that.cityBox) Vcity._m.addClass('hide', that.cityBox);
            if (that.ul) Vcity._m.addClass('hide', that.ul);
            if (that.myIframe) Vcity._m.addClass('hide', that.myIframe);
        });
        div.className = 'citySelector';
        div.style.position = 'absolute';
        div.style.left = inputPos.left + 'px';
        div.style.top = inputPos.bottom + 5 + 'px';
        div.style.zIndex = 999999;

        // 判断是否IE6，如果是IE6需要添加iframe才能遮住SELECT框
        var isIe = (document.all) ? true : false;
        var isIE6 = this.isIE6 = isIe && !window.XMLHttpRequest;
        if (isIE6) {
            var myIframe = this.myIframe = document.createElement('iframe');
            myIframe.frameborder = '0';
            myIframe.src = 'about:blank';
            myIframe.style.position = 'absolute';
            myIframe.style.zIndex = '-1';
            this.rootDiv.appendChild(this.myIframe);
        }

        var childdiv = this.cityBox = document.createElement('div');
        childdiv.className = 'cityBox';
        childdiv.id = 'cityBox';
        childdiv.innerHTML = Vcity._template.join('');
        var hotCity = this.hotCity = document.createElement('div');
        hotCity.className = 'hotCity';
        childdiv.appendChild(hotCity);
        div.appendChild(childdiv);
        this.createHotCity();
    },

    /* *
     * @createHotCity
     * TAB下面DIV：hot,a-h,i-p,q-z 分类HTML生成，DOM操作
     * {HOT:{hot:[]},ABCDEFGH:{a:[1,2,3],b:[1,2,3]},IJKLMNOP:{},QRSTUVWXYZ:{}}
     **/

    createHotCity: function () {
        var odiv, odl, odt, odd, odda = [], str, key, ckey, sortKey,
                oCity = Vcity.oCity;
        for (key in oCity) {
            odiv = this[key] = document.createElement('div');
            // 先设置全部隐藏hide
            odiv.className = key + ' ' + 'cityTab hide';
            sortKey = [];
            for (ckey in oCity[key]) {
                sortKey.push(ckey);
                // ckey按照ABCDEDG顺序排序
                sortKey.sort();
            }
            for (var j = 0, k = sortKey.length; j < k; j++) {
                odl = document.createElement('dl');
                odt = document.createElement('dt');
                odd = document.createElement('dd');
                odt.innerHTML = sortKey[j] == 'hot' ? '&nbsp;' : sortKey[j];
                odda = [];
                for (var i = 0, n = oCity[key][sortKey[j]].length; i < n; i++) {
                    str = '<a href="#" data="' + oCity[key][sortKey[j]][i].id + '">' + oCity[key][sortKey[j]][i].name + '</a>';
                    odda.push(str);
                }
                odd.innerHTML = odda.join('');
                odl.appendChild(odt);
                odl.appendChild(odd);
                odiv.appendChild(odl);
            }

            // 移除热门城市的隐藏CSS
            Vcity._m.removeClass('hide', this.hot);
            this.hotCity.appendChild(odiv);
        }
        document.body.appendChild(this.rootDiv);
        /* IE6 */
        this.changeIframe();

        this.tabChange();
        this.linkEvent();
    },

    /* *
     *  tab按字母顺序切换
     *  @ tabChange
     * */

    tabChange: function () {
        var lis = Vcity._m.$('li', this.cityBox);
        var divs = Vcity._m.$('div', this.hotCity);
        var that = this;
        for (var i = 0, n = lis.length; i < n; i++) {
            lis[i].index = i;
            lis[i].onclick = function () {
                for (var j = 0; j < n; j++) {
                    Vcity._m.removeClass('on', lis[j]);
                    Vcity._m.addClass('hide', divs[j]);
                }
                Vcity._m.addClass('on', this);
                Vcity._m.removeClass('hide', divs[this.index]);
                /* IE6 改变TAB的时候 改变Iframe 大小*/
                that.changeIframe();
            };
        }
    },

    /* *
     * 城市LINK事件
     *  @linkEvent
     * */

    linkEvent: function () {
        var links = Vcity._m.$('a', this.hotCity);
        var that = this;
        for (var i = 0, n = links.length; i < n; i++) {
            links[i].onclick = function () {
                that.input.value = this.innerHTML;
                that.input.setAttribute("data", this.getAttribute("data"));
                Vcity._m.addClass('hide', that.cityBox);
                /* 点击城市名的时候隐藏myIframe */
                Vcity._m.addClass('hide', that.myIframe);
            }
        }
    },

    /* *
     * INPUT城市输入框事件
     * @inputEvent
     * */

    inputEvent: function () {
        var that = this;
        Vcity._m.on(this.input, 'click', function (event) {
            event = event || window.event;
            if (!that.cityBox) {
                that.createWarp();
            } else if (!!that.cityBox && Vcity._m.hasClass('hide', that.cityBox)) {
                // slideul 不存在或者 slideul存在但是是隐藏的时候 两者不能共存
                if (!that.ul || (that.ul && Vcity._m.hasClass('hide', that.ul))) {
                    Vcity._m.removeClass('hide', that.cityBox);

                    /* IE6 移除iframe 的hide 样式 */
                    //alert('click');
                    Vcity._m.removeClass('hide', that.myIframe);
                    that.changeIframe();
                }
            }
        });
        // Vcity._m.on(this.input,'focus',function(){
        //     that.input.select();
        //     if(that.input.value == '城市名') that.input.value = '';
        // });
        Vcity._m.on(this.input, 'blur', function () {
            // if(that.input.value == '') that.input.value = '城市名';

            var value = Vcity._m.trim(that.input.value).toUpperCase();
            if (value != '') {
                
                var flag = 0;
                for (var i = 0, n = allCity.length; i < n; i++) {
                   
                    if (Vcity._m.exitCity(value, allCity[i])) {
                        flag++;
                    }
                }
                if (flag == 0) {
                    that.input.value = '';
                } else {
                    var lis = Vcity._m.$('li', that.ul);
                    if (typeof lis == 'object' && lis['length'] > 0) {
                        var li = lis[0];
                        var bs = li.children;
                        if (bs && bs['length'] > 1) {
                            that.input.value = bs[0].innerHTML;
                            that.input.setAttribute("data", li.getAttribute("data"));
                        }
                    } else {
                        that.input.value = '';
                    }
                }
            }

        });
        Vcity._m.on(this.input, 'keyup', function (event) {
            event = event || window.event;
            var keycode = event.keyCode;
            Vcity._m.addClass('hide', that.cityBox);
            that.createUl();

            /* 移除iframe 的hide 样式 */
            Vcity._m.removeClass('hide', that.myIframe);

            // 下拉菜单显示的时候捕捉按键事件
            if (that.ul && !Vcity._m.hasClass('hide', that.ul) && !that.isEmpty) {
                that.KeyboardEvent(event, keycode);
            }
        });
    },

    /* *
     * 生成下拉选择列表
     * @ createUl
     * */

    createUl: function () {
        //console.log('createUL');
        var str;
        var value = Vcity._m.trim(this.input.value).toUpperCase();
        // 当value不等于空的时候执行
        if (value !== '') {

            // 此处需设置中文输入法也可用onpropertychange
            var searchResult = [];
            for (var i = 0, n = allCity.length; i < n; i++) {
                var match = allCity[i];
                if (Vcity._m.exitCity(value, match)) {

                    if (searchResult.length !== 0) {
                        str = '<li data="' + match.id + '"><b class="cityname">' + match.name + '</b><b class="cityspell">' + match.code + '</b></li>';
                    } else {
                        str = '<li class="on" data="' + match.id + '"><b class="cityname">' + match.name + '</b><b class="cityspell">' + match.code + '</b></li>';
                    }
                    searchResult.push(str);
                }
            }
            this.isEmpty = false;
            // 如果搜索数据为空
            if (searchResult.length == 0) {
                this.isEmpty = true;
                str = '<li class="empty">对不起，没有找到 "<em>' + value + '</em>"</li>';
                searchResult.push(str);
            }
            // 如果slideul不存在则添加ul
            if (!this.ul) {
                var ul = this.ul = document.createElement('ul');
                ul.className = 'cityslide mCustomScrollbar';
                this.rootDiv && this.rootDiv.appendChild(ul);
                // 记录按键次数，方向键
                this.count = 0;
            } else if (this.ul && Vcity._m.hasClass('hide', this.ul)) {
                this.count = 0;
                Vcity._m.removeClass('hide', this.ul);
            }
            this.ul.innerHTML = searchResult.join('');

            /* IE6 */
            this.changeIframe();

            // 绑定Li事件
            this.liEvent();
        } else {
            Vcity._m.addClass('hide', this.ul);
            Vcity._m.removeClass('hide', this.cityBox);

            Vcity._m.removeClass('hide', this.myIframe);

            this.changeIframe();
        }
    },

    /* IE6的改变遮罩SELECT 的 IFRAME尺寸大小 */
    changeIframe: function () {
        if (!this.isIE6) return;
        this.myIframe.style.width = this.rootDiv.offsetWidth + 'px';
        this.myIframe.style.height = this.rootDiv.offsetHeight + 'px';
    },

    /* *
     * 特定键盘事件，上、下、Enter键
     * @ KeyboardEvent
     * */

    KeyboardEvent: function (event, keycode) {
        var lis = Vcity._m.$('li', this.ul);
        var len = lis.length;
        switch (keycode) {
            case 40: //向下箭头↓
                this.count++;
                if (this.count > len - 1) this.count = 0;
                for (var i = 0; i < len; i++) {
                    Vcity._m.removeClass('on', lis[i]);
                }
                Vcity._m.addClass('on', lis[this.count]);
                break;
            case 38: //向上箭头↑
                this.count--;
                if (this.count < 0) this.count = len - 1;
                for (i = 0; i < len; i++) {
                    Vcity._m.removeClass('on', lis[i]);
                }
                Vcity._m.addClass('on', lis[this.count]);
                break;
            case 13: // enter键
                this.input.value = Vcity.regExChiese.exec(lis[this.count].innerHTML)[0];
                Vcity._m.addClass('hide', this.ul);
                Vcity._m.addClass('hide', this.ul);
                /* IE6 */
                Vcity._m.addClass('hide', this.myIframe);
                break;
            default:
                break;
        }
    },

    /* *
     * 下拉列表的li事件
     * @ liEvent
     * */

    liEvent: function () {
        var that = this;
        var lis = Vcity._m.$('li', this.ul);
        for (var i = 0, n = lis.length; i < n; i++) {
            Vcity._m.on(lis[i], 'click', function (event) {
                event = Vcity._m.getEvent(event);
                var target = Vcity._m.getTarget(event);                
                that.input.value = Vcity.regExChiese.exec(target.innerHTML)[0];
                that.input.setAttribute("data", target.getAttribute("data"));
                Vcity._m.addClass('hide', that.ul);
                /* IE6 下拉菜单点击事件 */
                Vcity._m.addClass('hide', that.myIframe);
            });
            Vcity._m.on(lis[i], 'mouseover', function (event) {
                event = Vcity._m.getEvent(event);
                var target = Vcity._m.getTarget(event);
                Vcity._m.addClass('on', target);
            });
            Vcity._m.on(lis[i], 'mouseout', function (event) {
                event = Vcity._m.getEvent(event);
                var target = Vcity._m.getTarget(event);
                Vcity._m.removeClass('on', target);
            })
        }
    }
};