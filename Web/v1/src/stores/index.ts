
/**
 * router.js
 * @author: 一颗橘子唐
 * @description: 状态配置
 * @create: 2024年3月27日15:20:19
 */

import { ref } from 'vue'
import { defineStore } from 'pinia'

/**
 * UserData store
 */
export const useUserData = defineStore('UserData', () => {
  const uuid = ref('0000001');
  const userstate = ref("admin");

  function setUserData(data: any) {
    uuid.value = data.uuid;
    userstate.value = data.userstate;
  }
  return { uuid, userstate, setUserData }
})

/**
 * SiteData store
 */
export const useSiteData = defineStore('SiteData', () => {
  const siteName = ref("Site Name");
  const siteSubTitle = ref("Site Sub Title");
  const siteDescription = ref("Site Description");
  const siteFavicon = ref("/favicon.jpg");
  const isLogin = ref(false);
  function setSiteData(data: any) {
    siteName.value = data.sitename;
    siteSubTitle.value = data.sitesubtitle;
    siteFavicon.value = data.sitefavicon;
    siteDescription.value = data.sitedescription;
  }
  return {isLogin, siteName, siteFavicon, siteSubTitle, siteDescription, setSiteData }
})
