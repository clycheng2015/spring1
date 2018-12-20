const fs = require('fs');
const path = require('path');



export const readFileToJson = (pathName) => {
    let objs = [];
    //读取路径,返回所有文件节点=文件夹+文件
    let filePath = "F:/SpringBootFiles/Image/img.json";//输出路径
    fs.readdir(pathName, (err, files) => {//读文件夹
        for (let file of files) {//遍历文件
            let oldName = path.join('F:/SpringBootFiles/Image', file);//文件旧路径
            let extname = path.extname(file);//文件后缀名
            let basename = path.basename(file, extname);//文件名除去后缀(这里没有到，提一下)
            let newName = rangeChar(16, true) + extname;//新名称，随机获取16个字符
            fs.rename(oldName, path.join('F:/SpringBootFiles/Image', newName), err => {
            });//重命名

            let obj = {};//定义对象
            obj.img = newName;//该对象img属性为新文件名称
            objs.push(obj);//将对象添到数组中
        }

        fs.writeFileSync(filePath, JSON.stringify(objs), {encoding: 'utf8'})//写入数据
    });
}

export const rangeChar=(len, hasBig = false) =>{
    let allLen = 25;
    let chars = ["a", "b", "c", "d", "e", "f", "g",
        "h", "i", "j", "k", "l", "m", "n",
        "o", "p", "q", "r", "s", "t",
        "u", "v", "w", "x", "y", "z"];
    let charsBig = chars.map(item => item.toUpperCase());

    if (hasBig) {
        chars = chars.concat(charsBig);
        allLen = 49;
    }
    let result = [];
    for (let i = 0; i < len; i++) {
        let char = chars[rangeInt(0, allLen)];
        result.push(char);
    }
    return result.join('');
};

export const rangeInt=(s, e)=> {
    let max = Math.max(s, e);
    let min = Math.min(s, e) - 1;
    return min + Math.ceil(Math.random() * (max - min));
};
