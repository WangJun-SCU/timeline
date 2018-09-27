var init = "初始化变量";

var vm = new Vue({
    el: '#vue',
    data: {
        uploadUrl: host + "/upload",
        drawerUpload: false,
        uploadCatalog: -1,
        catalogs: [],
        uploadType: "image/*,video/*",
        uploadData: { 
        	catalogId: -1
        }
    },
    methods: {
        beforeUpload(file) {
        	debugger;
            if (this.uploadCatalog == -1) {
                this.$Message.error("请选择上传目录！");
                return false;
            } else {
                this.uploadData.catalogId = this.uploadCatalog;
            }
            return true;
        }
    },
    created: function() {
        // （VUE的生命周期）VUE 实例被创建后执行
        let that = this;
        $.ajax({
            url: host + "/catalogs",
            success: function(res) {
                if (res.code == 0) {
                    that.catalogs = res.body;
                } else {
                    that.$Message.error("查询目录失败！" + res.message);
                }
            },
            error: function(error) {
                that.$Message.error("查询目录错误！" + error);
            }
        });
    }
});