
var vm = new Vue({
    el: '#vue',
    data: {
        uploadUrl: host + "/timeline/upload", //上传文件的请求地址
        drawerUpload: false, //是否显示内容管理的抽屉视图
        drawerShow: 1, //1：查询目录，2：添加目录，3：上传文件
        loadingSearchCatalogs: false, //表格加载状态
        uploadCatalog: -1, //上传时选择的目录
        catalogs: [], //上传时可供选择的目录列表
        uploadType: "image/*,video/*", //允许上传的类型
        addCatalogParam: {
        	name: "",
        	location: "",
        	time: "",
        	description: "",
        	rules: {
        		location: [
        			{ required: true, message: 'The name cannot be empty', trigger: 'blur' }
        		],
        		time: [
        			{required: true, type: 'date', message: "时间不能为空", trigger: 'change'}
        		]
        	}
        },
        uploadData: { 
        	catalogId: -1
        },
        catalogColumn: [
        	{
        		title: "序号",
        		type: "index",
        		maxWidth: 70,
        	},
        	{
        		title: "目录名",
        		key: "name"
        	},
        	{
        		title: "地点",
        		key: "location"
        	},
        	{
        		title: "时间",
        		key: "time"
        	},
        	{
        		title: "描述",
        		key: "description"
        	}
        ],
        catalogData: [
        ]
    },
    methods: {
        beforeUpload(file) {
            if (this.uploadCatalog == -1) {
                this.$Message.error("请选择上传目录！");
                return false;
            } else {
                this.uploadData.catalogId = this.uploadCatalog;
            }
            return true;
        },
        addCatalog() {
        	if(this.addCatalogParam.location == "" || this.addCatalogParam.time == ""){
        		this.$Message.warning("非空参数必填");
        		return;
        	}
        	let req = {
        		name: this.addCatalogParam.name,
        		location: this.addCatalogParam.location,
        		time: this.addCatalogParam.time.getTime(),
        		description: this.addCatalogParam.description
        	};
        	req = JSON.stringify(req);
        	let that = this;
        	$.ajax({
				url: host + "/timeline/catalogs",
				data: req,
				type: "POST",
				contentType: "application/json",
				success: function (res) {
					if(res.code == 0){
						that.$Message.success("提交成功");
						that.addCatalogReset("addCatalogForm");
						that.queryCatalogs();
					}else{
						that.$Message.error("提交失败！" + res.message);
					}
				},
				error: function(){
					that.$Message.error("提交出错！");
				}
			});
        },
        addCatalogReset(name) {
        	this.$refs[name].resetFields();
        },
        queryCatalogs(){
        	this.catalogs = [];
        	this.catalogData = [];
        	this.drawerShow = 1;
        	this.loadingSearchCatalogs = true;
        	let that = this;
        	$.ajax({
	            url: host + "/timeline/catalogs",
	            success: function(res) {
	            	that.loadingSearchCatalogs = false;
	                if (res.code == 0) {
	                    that.catalogs = res.body;
	                    for(let i = 0; i < that.catalogs.length; i++){
	                    	let item = {
	                    		id: that.catalogs[i].id,
	                    		name: that.catalogs[i].name,
	                    		location: that.catalogs[i].location,
	                    		time: time2str(that.catalogs[i].time),
	                    		description: that.catalogs[i].description
	                    	}
	                    	that.catalogData.push(item);
	                    }
	                } else {
	                    that.$Message.error("查询目录失败！" + res.message);
	                }
	            },
	            error: function(error) {
	            	that.loadingSearchCatalogs = false;
	                that.$Message.error("查询目录错误！" + error);
	            }
        	});
        },
        showAddCatalog() {
        	this.drawerShow = 2;
        },
        showUpload() {
        	this.drawerShow = 3;
        },
        uploadSuccess(response, file, fileList) {
        	if(response.code == 0){
        		this.$Message.success("上传成功");
        	}else{
        		this.$Message.error("上传失败！" + response.message);
        	}
        },
        uploadError(error, file, fileList){
        	this.$Message.error("上传失败");
        },
        uploadPreview(file) {
        	let url = file.response.body;
        	window.open(url);   
        }
    },
    created: function() {
        // （VUE的生命周期）VUE 实例被创建后执行
        this.queryCatalogs();
    }
});