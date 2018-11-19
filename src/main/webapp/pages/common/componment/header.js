var indexPage = host + "/timeline/pages/index.html";

Vue.component('tl-header', {
	template: `
		<div style="height:70px;line-height:70px;background-color:#515a6e;">
			<a :href="indexPage"><img src="/timeline/pages/common/imgs/timeline_white.png" alt="图片" style="height: 50px; vertical-align:middle;"/></a>
			<a :href="indexPage"><span style="color:#c7c7c7;font-size: 14px;">那些值得留念的时刻...</span></a>
		</div>
	`
})