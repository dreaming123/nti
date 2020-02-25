import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'


//import login  from '@/page/login'

Vue.use(Router)


const login = r => require.ensure([], () => r(require('@/page/login')), 'login');
const manager = r => require.ensure([], () => r(require('@/page/manager')), 'manager');
const addExcel = r => require.ensure([], () => r(require('@/page/addExcel')), 'addExcel');
const test1 = r => require.ensure([], () => r(require('@/components/test1')), 'test1');

export default new Router({
  routes: [
    {
      path: '/hellow',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name:'login',
      component: login
    },
    {
      path: '/manager',
      name:'manager',
      component: manager,
      children:[{
        path:'/test1',
        name:'test1',
        component:test1
      },{
        path:'/addExcel',
        name:'addExcel',
        component: addExcel
      }
    ]
    },
    {
      path: '/addExcel',
      name:'addExcel',
      component: addExcel
    },
   /* {
      path: '/test1',
      name:'test1',
      component: test1
    }, */
  ]
})
