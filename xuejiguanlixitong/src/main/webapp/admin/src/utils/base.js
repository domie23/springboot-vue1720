const base = {
    get() {
        return {
            url : "http://localhost:8080/xuejiguanlixitong/",
            name: "xuejiguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xuejiguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "学籍管理系统"
        } 
    }
}
export default base
