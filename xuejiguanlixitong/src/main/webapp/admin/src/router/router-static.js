import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import chengji from '@/views/modules/chengji/list'
    import dianziwendang from '@/views/modules/dianziwendang/list'
    import dictionary from '@/views/modules/dictionary/list'
    import kechng from '@/views/modules/kechng/list'
    import news from '@/views/modules/news/list'
    import yonghu from '@/views/modules/yonghu/list'
    import dictionaryChengji from '@/views/modules/dictionaryChengji/list'
    import dictionaryDianziwendang from '@/views/modules/dictionaryDianziwendang/list'
    import dictionaryKechng from '@/views/modules/dictionaryKechng/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryYuanxi from '@/views/modules/dictionaryYuanxi/list'
    import dictionaryZhengzimianmao from '@/views/modules/dictionaryZhengzimianmao/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryChengji',
        name: '学科类型',
        component: dictionaryChengji
    }
    ,{
        path: '/dictionaryDianziwendang',
        name: '文档类型',
        component: dictionaryDianziwendang
    }
    ,{
        path: '/dictionaryKechng',
        name: '课程类型',
        component: dictionaryKechng
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryYuanxi',
        name: '院系',
        component: dictionaryYuanxi
    }
    ,{
        path: '/dictionaryZhengzimianmao',
        name: '政治面貌',
        component: dictionaryZhengzimianmao
    }


    ,{
        path: '/chengji',
        name: '成绩信息',
        component: chengji
      }
    ,{
        path: '/dianziwendang',
        name: '电子文档',
        component: dianziwendang
      }
    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/kechng',
        name: '课程信息',
        component: kechng
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/yonghu',
        name: '学生',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
