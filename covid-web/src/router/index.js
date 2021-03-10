import Vue from 'vue'
import Router from 'vue-router'

import Login from '@/components/login'
import Main from '@/components/Main'
import Track from '@/components/covidTrack'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect:'/main'
    },
    {
      path:'/login',
      name:'login',
      component:Login,
      meta:{
        keepAlive:true
      }
    },
    {
      path:'/main',
      name:'main',
      component:Main,
      meta:{
        keepAlive:true
      }
    },
    {
      path:'/track',
      name:'track',
      component:Track,
      meta:{
        keepAlive:true
      }
    }
  ]
})
