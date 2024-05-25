<template>
    <div class="Login-Container">
        <el-card class="card" shadow="always">
            <el-form style="text-align: center;" ref="LoginFormRef" :model="LoginForm" status-icon :rules="rules">
                <el-form-item prop="uuid">
                    <el-input v-model="LoginForm.uuid" clearable autocomplete="off">
                        <template #prepend>
                            <el-icon>
                                <User />
                            </el-icon>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item prop="passwd">
                    <el-input v-model="LoginForm.passwd" clearable show-password autocomplete="off">
                        <template #prepend>
                            <el-icon>
                                <Lock />
                            </el-icon>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item label-width="auto">
                    <div class="FormBtns-Container">
                        <el-button type="primary" @click="onSubmit(LoginFormRef)">登录</el-button>
                        <el-button @click="onCancel(LoginFormRef)">取消</el-button>
                    </div>
                </el-form-item>
            </el-form>
        </el-card>
    </div>
</template>

<script setup lang="ts">
import { reactive, ref } from 'vue'
import { ElMessage, type FormInstance, type FormRules, type MessageParamsWithType } from 'element-plus'
import { useRouter } from 'vue-router'
import axios from 'axios';
const router = useRouter()
const LoginFormRef = ref<FormInstance>()

// 前端验证账号密码格式是否正确
const validateUuid = (rule: any, value: any, callback: any) => {
    if (!value) {
        callback(new Error());
    } else if (!/^[a-zA-Z][a-zA-Z0-9]{4,11}$/.test(value)) {
        callback(new Error('UUID格式错误!'));
    } else {
        callback(); // 验证通过
    }
}
const validatePasswd = (rule: any, value: any, callback: any) => {
    if (!value) {
        callback(new Error());
    } else if (!/^[a-zA-Z0-9@!#.]{4,16}$/.test(value)) {
        callback(new Error("密码格式错误!"));
    } else {
        callback(); // 验证通过
    }
};

const LoginForm = reactive({
    uuid: '',
    passwd: '',
})

const rules = reactive<FormRules<typeof LoginForm>>({
    uuid: [{ validator: validateUuid, trigger: ['change'] }],
    passwd: [{ validator: validatePasswd, trigger: ['change'] }],
})

const onSubmit = (formEl: FormInstance | undefined) => {
    if (!formEl)
        return
    formEl.validate((valid) => {
        if (valid) {
            const jsonData = {
                username: LoginForm.uuid,
                password: LoginForm.passwd,
            };
            axios.post('/api/login', jsonData).then((response: any) => { 
                if (response.data.msg === 'success') { 
                    ElMessage.success('登录成功!,即将跳转到先前页面...')
                    setTimeout(() => { 
                        router.go(-1) 
                        formEl.resetFields()
                    }, 2500)
                } else {
                    ElMessage.error('登录失败，请检查您的用户名或密码是否正确。')
                    return false
                }
            }).catch((error: any) => {
                ElMessage.error(error) 
            })
        } else {
            console.log('error submit!')
            return false
        }
    })
}
const onCancel = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    formEl.resetFields()
    router.go(-1)
}
</script>

<style scoped>
.Login-Container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100%;
    width: 100%;
}
.card {
    width: 320px;
    padding: 1em;
    background: var(--floatbar-bg-color);
    box-shadow: var(--el-box-shadow);
    backdrop-filter: blur(1em);
    -webkit-backdrop-filter: blur(1em);
}
.FormBtns-Container {
    width: 100%;

}
.el-form-item:last-child {
    margin-bottom: 0
}
</style>